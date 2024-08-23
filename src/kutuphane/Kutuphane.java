package kutuphane;

import kullanicilar.Okuyucu;
import kullanicilar.KutuphaneGorevlisi;
import java.util.*;

public class Kutuphane {
    private Map<String, Kitap> kitaplar;
    private Set<Okuyucu> okuyucular;
    private Map<String, String> oduncVerilenKitaplar;
    private static final int MAKS_KITAP_SINIRI = 5;
    private static final int ODUNC_GUNU = 7; // Ödünç alma süresi 7 gün olarak sabitlendi

    public Kutuphane() {
        this.kitaplar = new HashMap<>();
        this.okuyucular = new HashSet<>();
        this.oduncVerilenKitaplar = new HashMap<>();
    }

    public void kitapEkle(Kitap kitap){
        kitaplar.put(kitap.getKitapId(), kitap);
    }

    public void kitapGuncelle(String kitapId) {
        Kitap kitap = kitaplar.get(kitapId);
        if (kitap != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Yeni Başlık: ");
            kitap.setBaslik(scanner.nextLine());
            System.out.println("Yeni Fiyat: ");
            kitap.setFiyat(scanner.nextDouble());
            System.out.println("Yeni Kategori: ");
            kitap.setKategori(scanner.next());
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void kitapSil(String kitapId){
        kitaplar.remove(kitapId);
    }

    public Kitap kitapBulIdIle(String kitapId) {
        return kitaplar.get(kitapId);
    }

    public List<Kitap> kitaplariBulYazarIle(String yazarIsmi){
        List<Kitap> sonuc = new ArrayList<>();
        for (Kitap kitap : kitaplar.values()) {
            if (kitap.getYazar().getIsim().equalsIgnoreCase(yazarIsmi)) {
                sonuc.add(kitap);
            }
        }
        return sonuc;
    }

    public List<Kitap> kitaplariBulKategoriIle(String kategori) {
        List<Kitap> sonuc = new ArrayList<>();
        for (Kitap kitap : kitaplar.values()) {
            if (kitap.getKategori().equalsIgnoreCase(kategori)) {
                sonuc.add(kitap);
            }
        }
        return sonuc;
    }

    public double toplamKitapFiyati() {
        double toplamFiyat = 0;
        for (Kitap kitap : kitaplar.values()) {
            toplamFiyat += kitap.getFiyat();
        }
        return toplamFiyat;
    }

    public void okuyucuEkle(Okuyucu okuyucu){
        okuyucular.add(okuyucu);
    }

    public Okuyucu okuyucuBul(String okuyucuId) {
        for (Okuyucu okuyucu : okuyucular) {
            if (okuyucu.getId().equals(okuyucuId)) {
                return okuyucu;
            }
        }
        return null;
    }

    public void kitaplariListele(){
        for (Kitap kitap : kitaplar.values()) {
            System.out.println(kitap);
        }
    }

    public void kitapOduncAl(String kitapId, String okuyucuId) {
        Kitap kitap = kitapBulIdIle(kitapId);
        Okuyucu okuyucu = okuyucuBul(okuyucuId);

        if (kitap == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }

        if (oduncVerilenKitaplar.containsKey(kitapId)) {
            System.out.println("Bu kitap zaten ödünç verilmiş.");
            return;
        }

        if (okuyucu == null) {
            System.out.println("Okuyucu bulunamadı.");
            return;
        }

        if (okuyucu.getOduncAlinanKitaplar().size() >= MAKS_KITAP_SINIRI) {
            System.out.println("Okuyucu zaten maksimum sayıda kitap ödünç aldı.");
            return;
        }

        kitap.setDurum(Durum.ODUNC_ALINDI);
        okuyucu.getOduncAlinanKitaplar().add(kitap);
        oduncVerilenKitaplar.put(kitapId, okuyucuId);
        System.out.println(okuyucu.getIsim() + " adlı okuyucu " + kitap.getBaslik() + " kitabını ödünç aldı.");
    }

    public void kitapIadeEt(String kitapId, String okuyucuId) {
        Kitap kitap = kitapBulIdIle(kitapId);
        Okuyucu okuyucu = okuyucuBul(okuyucuId);

        if (kitap == null || okuyucu == null) {
            System.out.println("Kitap veya okuyucu bulunamadı.");
            return;
        }

        if (kitap.getDurum() == Durum.ODUNC_ALINDI && oduncVerilenKitaplar.containsKey(kitapId)) {
            okuyucu.getOduncAlinanKitaplar().remove(kitap);
            kitap.setDurum(Durum.MEVCUT);
            oduncVerilenKitaplar.remove(kitapId);
            System.out.println("Kitap başarıyla iade edildi.");
        } else {
            System.out.println("Bu kitap zaten kütüphanede veya iade edilemez.");
        }
    }

    public void cezaHesapla(String okuyucuId, int iadeGunu) {
        Okuyucu okuyucu = okuyucuBul(okuyucuId);
        if (okuyucu == null) {
            System.out.println("Okuyucu bulunamadı.");
            return;
        }

        int gunFarki = iadeGunu - ODUNC_GUNU;
        double ceza = 0;
        if (gunFarki > 0) {
            ceza = gunFarki * 10.0;
            okuyucu.cezaEkle(ceza);
        }

        System.out.println("Toplam ceza: " + okuyucu.getCeza() + " TL");
    }

    public boolean sifreDogrula(KutuphaneGorevlisi gorevli, String girilenSifre) {
        return gorevli.sifreDogrula(girilenSifre);
    }
}

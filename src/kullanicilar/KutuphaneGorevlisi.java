package kullanicilar;

public class KutuphaneGorevlisi extends Kisi {

    private String sifre;

    public KutuphaneGorevlisi(String id, String isim, String iletisimBilgisi, String sifre) {
        super(id, isim, iletisimBilgisi);
        this.sifre = sifre;
    }

    public String getSifre(){
        return sifre;
    }

    @Override
    public void gorevTanimi() {
        System.out.println("Kütüphane görevlisinin görevi: Kitap yönetimi, kullanıcı yönetimi.");
    }

    public boolean sifreDogrula(String girilenSifre) {
        return this.sifre.equals(girilenSifre);
    }
}

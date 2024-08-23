package kutuphane;

import kullanicilar.Yazar;

public class Kitap {
    private String kitapId;
    private String baslik;
    private Yazar yazar;
    private double fiyat;
    private Durum durum;
    private String kategori;

    public Kitap(String kitapId, String baslik, Yazar yazar, double fiyat, String kategori) {
        this.kitapId = kitapId;
        this.baslik = baslik;
        this.yazar = yazar;
        this.fiyat = fiyat;
        this.durum = Durum.MEVCUT;
        this.kategori = kategori;
    }

    public String getKitapId() {
        return kitapId;
    }

    public void setKitapId(String kitapId) {
        this.kitapId = kitapId;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public Yazar getYazar() {
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Kitap [ID=" + kitapId + ", Baslik=" + baslik + ", Yazar=" + yazar.getIsim() + ", Fiyat=" + fiyat + ", Durum=" + durum.getDurumAciklamasi() + ", Kategori=" + kategori + "]";
    }
}

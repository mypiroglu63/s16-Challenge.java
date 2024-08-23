package kullanicilar;


public abstract class Kisi implements BilgiPaylasim {

    protected String id;
    protected String isim;
    protected String iletisimBilgisi;

    public Kisi(String id, String isim, String iletisimBilgisi){
        this.id = id;
        this.isim = isim;
        this.iletisimBilgisi = iletisimBilgisi;
    }

    public String getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getIletisimBilgisi() {
        return iletisimBilgisi;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setIletisimBilgisi(String iletisimBilgisi) {
        this.iletisimBilgisi = iletisimBilgisi;
    }

    public abstract void gorevTanimi();

    @Override
    public void bilgiPaylas() {
        System.out.println(isim + " bilgisini paylaştı.");
    }

    @Override
    public String toString() {
        return "Kisi [ID=" + id + ", Isim=" + isim + ", Iletisim=" + iletisimBilgisi + "]";
    }
}

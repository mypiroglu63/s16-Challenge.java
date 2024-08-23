package kullanicilar;

public class Yazar extends Kisi {


    public Yazar(String id, String isim, String iletisimBilgisi) {
        super(id, isim, iletisimBilgisi);
    }



    @Override
    public void gorevTanimi() {
        System.out.println("Yazar Görevi : Kitap yazma ve düzenleme");
    }
}

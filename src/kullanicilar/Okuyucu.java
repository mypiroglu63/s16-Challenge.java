package kullanicilar;

import kutuphane.Kitap;
import java.util.HashSet;
import java.util.Set;

public class Okuyucu extends Kisi {
    private Set<Kitap> oduncAlinanKitaplar = new HashSet<>();
    private double ceza;

    public Okuyucu(String id, String isim, String iletisimBilgisi) {
        super(id, isim, iletisimBilgisi);
        this.ceza = 0;
    }

    public void cezaEkle(double ceza) {
        this.ceza += ceza;
    }

    public double getCeza() {
        return ceza;
    }

    public Set<Kitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }

    @Override
    public void gorevTanimi() {
        System.out.println("Okuyucu görevleri: Kitap ödünç alma ve iade etme.");
    }
}

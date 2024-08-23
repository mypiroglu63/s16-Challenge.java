package kutuphane;

public enum Durum {
    MEVCUT("Mevcut"),
    ODUNC_ALINDI("Ödünç Alındı");


    private final String durumAciklamasi;

    Durum(String durumAciklamasi) {
        this.durumAciklamasi = durumAciklamasi;
    }

    public String getDurumAciklamasi() {
        return durumAciklamasi;
    }
}

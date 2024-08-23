import kutuphane.Kutuphane;
import kutuphane.Kitap;
import kullanicilar.KutuphaneGorevlisi;
import kullanicilar.Okuyucu;
import kullanicilar.Yazar;
import kullanicilar.Kisi;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();
        Scanner scanner = new Scanner(System.in);


        Kisi gorevli = new KutuphaneGorevlisi("1", "Ayşe Görevli", "ayse@kutuphane.com", "12345");
        Kisi yazar1 = new Yazar("1", "Mehmet Yazar", "mehmet@gmail.com");
        Kisi okuyucu1 = new Okuyucu("1", "Ali Okur", "ali@gmail.com");


        gorevli.bilgiPaylas();
        yazar1.bilgiPaylas();
        okuyucu1.bilgiPaylas();


        gorevli.gorevTanimi();
        yazar1.gorevTanimi();
        okuyucu1.gorevTanimi();


        System.out.print("Görevli Şifresini Girin: ");
        String girilenSifre = scanner.nextLine();

        if (!kutuphane.sifreDogrula((KutuphaneGorevlisi) gorevli, girilenSifre)) {
            System.out.println("Şifre yanlış! İşlemler yapılamaz.");
            return;
        }

        String secim;
        do {
            System.out.println("1. Yeni Kitap ve Yazar Ekle");
            System.out.println("2. Kitap Ara (ID)");
            System.out.println("3. Kitap Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kategorideki Kitapları Listele");
            System.out.println("6. Yazara Göre Kitapları Listele");
            System.out.println("7. Tüm Kitapları Listele");
            System.out.println("8. Kütüphanedeki Toplam Kitap Fiyatını Görüntüle");
            System.out.println("9. Kitap İade Et");
            System.out.println("10. Kitap Ödünç Al");
            System.out.println("11. Yeni Okuyucu Ekle");
            System.out.println("12. Yazar İçin Yeni Kitap Yaz");
            System.out.println("13. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    System.out.print("Kitap ID: ");
                    String kitapId = scanner.nextLine();
                    System.out.print("Kitap Başlığı: ");
                    String baslik = scanner.nextLine();
                    System.out.print("Yazar ID: ");
                    String yazarId = scanner.nextLine();
                    System.out.print("Yazar İsmi: ");
                    String yazarIsim = scanner.nextLine();
                    System.out.print("Yazar İletişim Bilgisi: ");
                    String yazarIletisim = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double fiyat = scanner.nextDouble();
                    System.out.print("Kategori: ");
                    String kategori = scanner.next();
                    scanner.nextLine();

                    Yazar yeniYazar = new Yazar(yazarId, yazarIsim, yazarIletisim);
                    Kitap yeniKitap = new Kitap(kitapId, baslik, yeniYazar, fiyat, kategori);
                    kutuphane.kitapEkle(yeniKitap);
                    System.out.println("Yeni kitap ve yazar eklendi!");
                    break;

                case "2":
                    System.out.print("Kitap ID: ");
                    kitapId = scanner.nextLine();
                    Kitap bulunanKitap = kutuphane.kitapBulIdIle(kitapId);
                    if (bulunanKitap != null) {
                        System.out.println("Bulunan Kitap: " + bulunanKitap);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case "3":
                    System.out.print("Güncellenecek Kitap ID: ");
                    kitapId = scanner.nextLine();
                    kutuphane.kitapGuncelle(kitapId);
                    break;

                case "4":
                    System.out.print("Silinecek Kitap ID: ");
                    kitapId = scanner.nextLine();
                    kutuphane.kitapSil(kitapId);
                    System.out.println("Kitap silindi!");
                    break;

                case "5":
                    System.out.print("Kategori: ");
                    kategori = scanner.nextLine();
                    System.out.println("Kategoriye göre kitaplar: " + kutuphane.kitaplariBulKategoriIle(kategori));
                    break;

                case "6":
                    System.out.print("Yazar: ");
                    String yazarIsmi = scanner.nextLine();
                    System.out.println("Yazara göre kitaplar: " + kutuphane.kitaplariBulYazarIle(yazarIsmi));
                    break;

                case "7":
                    kutuphane.kitaplariListele();
                    break;

                case "8":
                    System.out.println("Kütüphanedeki Toplam Kitap Fiyatı: " + kutuphane.toplamKitapFiyati() + " TL");
                    break;

                case "9":
                    System.out.print("Kitap ID: ");
                    kitapId = scanner.nextLine();
                    System.out.print("Okuyucu ID: ");
                    String okuyucuId = scanner.nextLine();
                    System.out.print("İade Günü (1-365): ");
                    int iadeGunu = scanner.nextInt();
                    scanner.nextLine();

                    kutuphane.kitapIadeEt(kitapId, okuyucuId);
                    kutuphane.cezaHesapla(okuyucuId, iadeGunu);
                    break;

                case "10":
                    System.out.print("Kitap ID:. ");
                    kitapId = scanner.nextLine();
                    System.out.print("Okuyucu ID: ");
                    okuyucuId = scanner.nextLine();
                    kutuphane.kitapOduncAl(kitapId, okuyucuId);
                    break;

                case "11":
                    System.out.print("Yeni Kullanıcı ID: ");
                    String yeniOkuyucuId = scanner.nextLine();
                    System.out.print("Yeni Kullanıcı İsmi: ");
                    String yeniOkuyucuIsim = scanner.nextLine();
                    System.out.print("Yeni Kullanıcı İletişim: ");
                    String yeniOkuyucuIletisim = scanner.nextLine();

                    Okuyucu yeniOkuyucu = new Okuyucu(yeniOkuyucuId, yeniOkuyucuIsim, yeniOkuyucuIletisim);
                    kutuphane.okuyucuEkle(yeniOkuyucu);
                    System.out.println("Yeni okuyucu eklendi!");
                    break;

                case "12":
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        } while (!secim.equals("13"));

        scanner.close();
    }
}


package tugas1januari;
import java.util.ArrayList;
import java.util.Scanner;


public class Tugas1januari {

    
    public static ArrayList<rizki> riz = new ArrayList<>();
    static boolean masuk = true;
    static Scanner input = new Scanner (System.in);
  
    static boolean isi = true;
    static class burhan{
    
    }
    static class rizki {
        String nama , alamat , namas, nomermm;
        int hargas , totals, bayar;
        rizki(String Nama,String alamat ,  String namas , int harga , int totals, int bayar){
            this.nama = Nama;
            this.alamat = alamat;
            this.hargas = harga;
            this.totals =totals;
            this.namas = namas;
            this.bayar = bayar;
            
        }

     

    }
    static void menu (){
         System.out.println("===========  MEUN ==========");

      System.out.println("[1]. Show All Servis ");
      System.out.println("[2]. Isi Data ");
      System.out.println("[3]. Edit  ");
      System.out.println("[4]. Hapus  ");
      System.out.println("[5]. Cetak Data");
      System.out.println("[6]. Seesai");
      System.out.print("Plih Menu >>");
      
       int pilih = input.nextInt();
      
      switch(pilih){
          case 1:
              showall();
              break;
          case 2:
              isiData();
              break;
          case 3:
               edit();
               break;
          case 4:
              hapus();
              break;
          case 5:
              cetak();
              break;
          case 6: 
              System.exit(0);
              System.out.println("  TERIMA KASIH ");
              break;
          default:
              System.out.println("Pilihan Salah");
      }
  
    }
    
    private static void macan(){
    
    }
   
    
    static void isiData (){
      isi = true;
      String namass  = "", jawab = "", Nama = "";
      String nomerm = "";
      int  harga  = 0  , pilih = 0;
      int totals = 0;
      int bayar = 0;
       
     
      System.out.println(" \nServis Motor ");
      System.out.println("[1]. Ganti Oli");
      System.out.println("[2]. Ganti ban");
      System.out.println("[3]. Servis Lengkap " );
      System.out.println("[4]. Ganti VAN belt");
      System.out.println("[5]. Ganti Brake Shoe");
      System.out.println("[6]. Ganti Brake Pad");
      System.out.println("[7]. Turun Mesin");
     
      
      while(isi){
          System.out.print("Nama    = ");
          Nama = input.next();
          System.out.print("PlLAT motor = ");
          nomerm = input.next();
          
           System.out.print("Piliah >>> ");
      pilih = input.nextInt();
       switch(pilih ){
          case 1: 
              namass = " Ganti Oli ";
              harga = 90000;
              break;
          case 2: 
              namass = " Ganti ban";
              harga = 250000;
              break;
          case 3: 
              namass = " Servis Lengkap ";
              harga = 60000;
              break;
          case 4: 
              namass = " Ganti VAN belt ";
              harga = 35000;
              break;
          case 5: 
              namass =" Ganti Brake Shoe ";
              harga = 25000;
              break;
          case 6: 
              namass = " Ganti Brake Pad ";
              harga = 15000;
              break;
          case 7: 
              namass = " Turun Mesin ";
              harga = 150000;
              break;
          default :
              System.out.println("Pilihan Salah ");
      }
      
      totals += harga;
      System.out.println("");
      riz.add(new rizki(Nama,nomerm, namass, harga, totals, bayar));
      bayar = totals;
      
      System.out.print("Data lagi Y/T >> ");
      jawab = input.next();
      if (jawab.equalsIgnoreCase("T")){
      isi = false ;
      }
       
      }
}
     
 static void cetak() {
    final int halaman = 3;
    int totalpage = (int) Math.ceil((double) riz.size() / halaman);
    double totalgrand = 0;
    if (riz.isEmpty()){
        System.out.println("BELUM ADA DATA");
    }

    for (int apap = 1; apap <= totalpage; apap++) {

        System.out.println("                          LAPORAN SERVIS MOTOR           ");
        System.out.println("                               RISRIF SERVIS           \n ");
        System.out.println("Halaman " + apap + " dari " + totalpage);
        System.out.println("|=================================================================================|");
        System.out.printf("|%-5s|%-12s|%-20s|%-20s|%-20s|\n",
            "No",
            "Nama",
            "Plat Nomer",
            "Nama Servis",
            "Harga Servis"
        );
        System.out.println("|=================================================================================|");

        int bihun = (apap - 1) * halaman;
        int bakami = Math.min(bihun + halaman, riz.size());
        double subtotal1 = 0;

        for (int i = bihun; i < bakami; i++) {
            rizki servis = riz.get(i);

            System.out.printf("|%-5d|%-12s|%-20s|%-20s|%-20d|\n",
                i + 1,
                servis.nama,
                servis.alamat,
                servis.namas,
                servis.hargas
            );

            subtotal1 += servis.hargas; 
        }

        System.out.println("|=================================================================================|");
        System.out.printf("Subtotal Halaman %d: Rp %,.0f\n", apap, subtotal1);
        totalgrand += subtotal1; 

        if (apap == totalpage) {
            System.out.printf("Grand Total: Rp %,.0f\n", totalgrand);
            System.out.println("|=================================================================================|");
            System.out.println("Tekan Enter untuk menyelesaikan...");
            input.nextLine();
        } else {
            System.out.println("Tekan Enter untuk melanjutkan ke halaman berikutnya...");
            input.nextLine();
        }
        input.nextLine(); 
    }
}

  
  static void edit(){
 if (riz.isEmpty()) {
        System.out.println("BELUM ADA DATA ");
        return;
    }

    showall(); 
    System.out.print("Masukkan nomor data yang ingin diubah >> ");
    int nomor = input.nextInt();

    if (nomor < 1 || nomor > riz.size()) {
        System.out.println("Nomor tidak valid. Silakan coba lagi.");
        return;
    }

    rizki dataEdit = riz.get(nomor - 1); 

    
    System.out.print("Masukkan nama baru = ");
    input.nextLine(); 
    String namaBaru = input.nextLine();
    if (!namaBaru.isEmpty()) {
        dataEdit.nama = namaBaru;
    }

   
    System.out.print("Masukkan Plat Nomer = ");
    String nomerMotorBaru = input.nextLine();
    if (!nomerMotorBaru.isEmpty()) {
        dataEdit.alamat = nomerMotorBaru;
    }

    
    System.out.println("Pilih servis yang ingin diubah");
    System.out.println("[1]. Ganti Oli");
    System.out.println("[2]. Ganti ban");
    System.out.println("[3]. Servis Lengkap");
    System.out.println("[4]. Ganti VAN belt");
    System.out.println("[5]. Ganti Brake Shoe");
    System.out.println("[6]. Ganti Brake Pad");
    System.out.println("[7]. Turun Mesin");
    System.out.print("Pilihan >> ");
    int pilihanServis = input.nextInt();

    switch (pilihanServis) {
        case 1:
            dataEdit.namas = "Ganti Oli";
            dataEdit.hargas = 90000;
            break;
        case 2:
            dataEdit.namas = "Ganti ban";
            dataEdit.hargas = 250000;
            break;
        case 3:
            dataEdit.namas = "Servis Lengkap";
            dataEdit.hargas = 60000;
            break;
        case 4:
            dataEdit.namas = "Ganti VAN belt";
            dataEdit.hargas = 35000;
            break;
        case 5:
            dataEdit.namas = "Ganti Brake Shoe";
            dataEdit.hargas = 25000;
            break;
        case 6:
            dataEdit.namas = "Ganti Brake Pad";
            dataEdit.hargas = 15000;
            break;
        case 7:
            dataEdit.namas = "Turun Mesin";
            dataEdit.hargas = 150000;
            break;
        default:
            System.out.println("Pilihan salah. Data servis tidak diubah.");
    }

    System.out.println("Data berhasil diperbarui.");
    
}
  static void hapus (){
  isi = true ;
  while(isi){
  if (riz.isEmpty()){
      System.out.println("Belum Ada Data ");
  }
  showall();
      System.out.print("Masukan Nomer = " );
int masukan = input.nextInt();

if (masukan >= 1 && masukan <= riz.size()){
riz.remove(masukan-1);
    System.out.println("Telah dihapus");
}else {
    System.out.println("maaf salah ");
}
      System.out.print("apa masih ada lagi Y / T >>");
      String jawab = input.next();
      if (jawab.equalsIgnoreCase("T")){
      isi = false;
      
      }
  }
  
  }
  
    static void showall(){
        System.out.println("Show All Servis "); 
        if (riz.isEmpty()){
            System.out.println("Beluam Ada Data ");
        }else {
     System.out.println("|============================================================|");
         System.out.printf("|%-5s|%-12s|%-20s|%-20s|\n",
            "No",
            "Nama",
            "Plat Nomer",
            "Nama Servis"
           
      
        );
     System.out.println("|------------------------------------------------------------|");
        for (int i = 0 ; i < riz.size () ; i++){
        rizki dan = riz.get(i);
          
            System.out.printf("|%-5d|%-12s|%-20s|%-20s|\n",
                i + 1,
                dan.nama,
                dan.alamat,
                dan.namas
               
            );

           
        }
    System.out.println("|============================================================|");
        }
     
       
    }
    
  
  
                  
    public static void main (String[] args){
        macan();
       System.out.println("        *** BENGKEL ***        ");
      System.out.println("      *** SERVIS MOTOR ***       ");
      System.out.println("          ** RIZRIF **            ");
        System.out.println("                    ");
        do{
        menu();
        }while(masuk);
    }
    
   
    
}

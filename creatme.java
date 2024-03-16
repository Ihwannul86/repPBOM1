import java.util.Scanner;

class Student {
    public static String[] nama = new String[10];
    public static String[] fakultas = new String[10];
    public static String[] nim = new String[10];
    public static String[] prodi = new String[10];
    public static String[] bukuTerpinjam = new String[10];

    int checkStudent() {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nim anda (nim harus 15 digit!): ");
        String input = scanString.nextLine();
        for (int i = 0; i < nim.length; i++) {
            if (input.equals(nim[i])) {
                System.out.println("Sukses login sebagai student\n");
                return 1;
            }
        }
        System.out.println("Nim tidak ditemukan\n");
        return 0;
    }

    void pinjamBuku(int j) {
        Main main = new Main();
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan id buku yang ingin anda pinjam: ");
        String idBuku = scanString.nextLine();
        for (int i = 0; i < main.idBuku.length; i++) {
            if (idBuku.equals(main.idBuku[i])) {
                System.out.println("Buku id " + idBuku + " berhasil dipinjam");
                main.stock[i] -= 1;
                break;
            }
        }
        bukuTerpinjam[j] = idBuku;
    }

    void bukuTerpinjam() {
        System.out.println("Buku terpinjam: ");
        for (int i = 0; i < bukuTerpinjam.length; i++) {
            if (bukuTerpinjam[i] == null) {
                break;
            } else {
                System.out.printf("%d. %s\n", i + 1, bukuTerpinjam[i]);
            }
        }
    }
}

class Admin {
    Student student = new Student();
    public static String userx = "ihwan";
    public static String passx = "ihwan123";

    int checkAdmin() {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan Nama Asmin: ");
        String user = scanString.nextLine();
        System.out.print("Masukkan Password Admin: ");
        String pass = scanString.nextLine();
        if (user.equals(userx) && pass.equals(passx)) {
            System.out.println("Sukses login sebagai Admin\n");
            return 1;
        } else {
            System.out.println("Admin tidak ditemukan\n");
            return 0;
        }
    }

    void addStudent(int i) {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        Student.nama[i] = scanString.nextLine();

        System.out.print("Masukkan fakultas mahasiswa: ");
        Student.fakultas[i] = scanString.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        Student.nim[i] = scanString.nextLine();
        while (true) {
            if (String.valueOf(Student.nim[i]).length() != 15) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                student.nim[i] = scanString.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        Student.prodi[i] = scanString.nextLine();

        System.out.print("Data Mahasiswa berhasil ditambahkan.\n");
    }

    void dispayStudent(int i) {
        System.out.println("Data mahasiswa ke " + (i + 1));
        System.out.println("Nama: " + Student.nama[i]);
        System.out.println("Fakultas: " + Student.fakultas[i]);
        System.out.println("nim: " + Student.nim[i]);
        System.out.println("prodi: " + Student.prodi[i]);
    }
}

class Main {
    //data buku
    public static String[] idBuku = new String[] { "001", "002", "003" };
    public static String[] namaBuku = new String[] { "Naruto", "kage no jitsuryokusha", "Classroom of the Elite" };
    public static String[] author = new String[] { "Masashi   ", "Daisuke ", "Kunigasa" };
    public static String[] category = new String[] { "Sejarah", "komik", "Novel" };
    public static int[] stock = new int[] { 0, 1, 2 };

    void menuUtama() {
        System.out.println("\n==== Library System ====");
        System.out.println("1. Login sebagai Student");
        System.out.println("2. Login sebagai Admin");
        System.out.println("3. Exit");
        System.out.print("Pilihan Anda: ");
    }

    void menuStudent() {
        System.out.println("\n==== Student Menu ====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void menuAdmin() {
        System.out.println("\n==== Admin Menu ====");
        System.out.println("1. Tambah Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void displayBook() {
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No.\t || Id Buku || Nama Buku\t\t\t\t\t || Author\t\t\t || Category\t\t || Stock || ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("|| %d\t   || %s\t\t || %s\t || %s\t || %s\t || %d\t || \n", i, idBuku[i], namaBuku[i], author[i], category[i], stock[i]);
        }
        System.out.println("===========================================================================================================================================");
    }

    public static void main(String[] args) {
        Student student = new Student();
        Admin admin = new Admin();
        Main main = new Main();
        mainMenu: while (true) {
            main.menuUtama();
            Scanner scanInt = new Scanner(System.in);
            int pilih = scanInt.nextInt();
            if (pilih == 1) {
                if (student.checkStudent() == 0) {
                    continue mainMenu;
                }
                int j = 0;
                while (true) {
                    main.menuStudent();
                    pilih = scanInt.nextInt();
                    if (pilih == 1) {
                        student.bukuTerpinjam();
                    } else if (pilih == 2) {
                        main.displayBook();
                        student.pinjamBuku(j);
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (pilih == 2) {
                if (admin.checkAdmin() == 0) {
                    continue mainMenu;
                }
                while (true) {
                    main.menuAdmin();
                    pilih = scanInt.nextInt();
                    int i = 0;
                    if (pilih == 1) {
                        admin.addStudent(i);
                        i++;
                    } else if (pilih == 2) {
                        admin.dispayStudent(i);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}

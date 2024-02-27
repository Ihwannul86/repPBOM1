import java.util.Scanner;

public class creatme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password, nim;
        int choice;

        do {
            System.out.println("Pilih jenis user:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Masukkan username: ");
                    username = scanner.nextLine();

                    System.out.println("Masukkan password: ");
                    password = scanner.nextLine();

                    if (username.equals("admin") && password.equals("admin123")) {
                        System.out.println("Login berhasil sebagai admin.");
                    } else {
                        System.out.println("Login gagal. Username atau password salah.");
                    }
                    break;
                case 2:
                    System.out.println("Masukkan NIM (harus 15 karakter): ");
                    nim = scanner.nextLine();

                    if (nim.length() == 15) {
                        System.out.println("Login berhasil sebagai mahasiswa dengan NIM: " + nim);
                    } else {
                        System.out.println("Login gagal. Panjang NIM harus 15 karakter.");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
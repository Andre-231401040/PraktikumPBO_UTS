package soal3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        Selamat Datang di E-Lottery Gosok        ");
        System.out.println("=================================================");

        String pilihan = "y";
        int baris, kolom;
        boolean result, isGameOver;
        Scanner scanner = new Scanner(System.in);
        while(pilihan.equalsIgnoreCase("y")) {
            System.out.println();

            LotreBoard board = new LotreBoard();
            do {
                try {
                    board.displayBoard();

                    System.out.print("Masukkan tebakan anda (baris) : ");
                    baris = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan tebakan anda (kolom) : ");
                    kolom = Integer.parseInt(scanner.nextLine());

                    if(baris >= 0 && baris <= 3 && kolom >= 0 && kolom <= 4) {
                        if(!board.checkIsRevealed(baris, kolom)) {
                            result = board.guess(baris, kolom);
                            board.setBoard(baris, kolom);
                            board.setRevealed(baris, kolom);
                            if(result) {
                                isGameOver = board.checkIsGameOver();

                                if(isGameOver) {
                                    System.out.println("Selamat, anda berhasil memenangkan game ini.");
                                    board.displayBoard();
                                    break;
                                } else {
                                    System.out.println("Kotak Aman");
                                }
                            } else {
                                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                                board.displayBoard();
                                break;
                            }
                        } else {
                            System.out.println("Kotak ini telah dibuka sebelumnya.");
                        }
                    } else {
                        System.out.println("Tebakan anda tidak valid.");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Tebakan anda tidak valid.");
                }
            } while(true);


            System.out.println();
            System.out.println("Apakah anda ingin lanjut bermain? (y/n) : ");
            pilihan = scanner.nextLine();
        }

        System.out.println();
        System.out.println("=================================================");
        System.out.println("  Terima kasih sudah mampir di E-Lottery Gosok.  ");
        System.out.println("=================================================");
    }
}

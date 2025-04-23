package soal3;

import java.util.Random;

public class LotreBoard {
    private int totalSel = 20;
    private int[] posisiBom = new int[4];
    private int[][] data = new int[4][5];
    private char[][] board = new char[4][5];
    private boolean[][] revealed = new boolean[4][5];
    private Random random = new Random();

    public LotreBoard() {
        generateBoard();
    }

    public void setBoard(int baris, int kolom) {
        if(this.data[baris][kolom] != 1) {
            this.board[baris][kolom] = (char) (this.data[baris][kolom] + '0');
        } else {
            this.board[baris][kolom] = 'X';
        }
    }

    public void setRevealed(int baris, int kolom) {
        this.revealed[baris][kolom] = true;
    }

    private void generateBoard() {
        this.posisiBom = generateBombPosition();
        this.data[this.posisiBom[0]][this.posisiBom[2]] = 1;
        this.data[this.posisiBom[1]][this.posisiBom[3]] = 1;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                this.board[i][j] = '*';
            }
        }
    }

    public void displayBoard() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkIsRevealed(int baris, int kolom) {
        return this.revealed[baris][kolom];
    }

    public boolean guess(int baris, int kolom) {
        if(this.data[baris][kolom] != 1) {
            this.totalSel--;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsGameOver() {
        if(this.totalSel <= 2) {
            this.board[this.posisiBom[0]][this.posisiBom[2]] = 'X';
            this.board[this.posisiBom[1]][this.posisiBom[3]] = 'X';

            return true;
        } else {
            return false;
        }
    }

    private int[] generateBombPosition() {
        int baris1, baris2, kolom1, kolom2;

        do {
            baris1 = random.nextInt(4);
            baris2 = random.nextInt(4);
        } while (baris1 == baris2);

        kolom1 = random.nextInt(5);
        kolom2 = random.nextInt(5);

        return new int[]{baris1, baris2, kolom1, kolom2};
    }
}

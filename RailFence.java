package CryptoLab;

import java.util.Scanner;

public class RailFence {
        public static String Encryption(String plainText, int depth) {
            if (depth <= 1 || plainText == null || plainText.isEmpty()) {
                return plainText;
            }

            int len = plainText.length();
            char[][] mat = new char[depth][len];
            int row = 0, col = 0;
            boolean down = false;

            for (int i = 0; i < len; i++) {
                if (row == 0 || row == depth - 1) {
                    down = !down;
                }

                mat[row][col] = plainText.charAt(i);
                col++;

                if (down) {
                    row++;
                } else {
                    row--;
                }
            }

            StringBuilder cipherText = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < len; j++) {
                    if (mat[i][j] != '\0') {
                        cipherText.append(mat[i][j]);
                    }
                }
            }

            return cipherText.toString();
        }

        public static String Decryption(String cipherText, int depth) {
            if (depth <= 1 || cipherText == null || cipherText.isEmpty()) {
                return cipherText;
            }

            int len = cipherText.length();
            char[][] mat = new char[depth][len];
            int row = 0, col = 0;
            boolean down = false;

            for (int i = 0; i < len; i++) {
                if (row == 0) {
                    down = true;
                } else if (row == depth - 1) {
                    down = false;
                }

                mat[row][col] = 'X'; // Placeholder for characters in the rail
                col++;

                if (down) {
                    row++;
                } else {
                    row--;
                }
            }

            int index = 0;
            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < len; j++) {
                    if (mat[i][j] == 'X' && index < len) {
                        mat[i][j] = cipherText.charAt(index++);
                    }
                }
            }

            row = 0;
            col = 0;
            down = false;
            StringBuilder plainText = new StringBuilder();

            for (int i = 0; i < len; i++) {
                if (row == 0) {
                    down = true;
                } else if (row == depth - 1) {
                    down = false;
                }

                if (mat[row][col] != '\0') {
                    plainText.append(mat[row][col]);
                }
                col++;

                if (down) {
                    row++;
                } else {
                    row--;
                }
            }

            return plainText.toString();
        }



        public static void main(String args[]) {

            Scanner scn = new Scanner(System.in);
            int depth;
            String plainText, cipherText, decryptedText;

            System.out.println("Enter plain text:");
            plainText = scn.nextLine();

            System.out.println("Enter depth for Encryption:");
            depth = scn.nextInt();

            cipherText = Encryption(plainText, depth);
            System.out.println("Encrypted text is:\n" + cipherText);

            decryptedText = Decryption(cipherText, depth);
            System.out.println("Decrypted text is:\n" + decryptedText);

            scn.close();
        }
    }



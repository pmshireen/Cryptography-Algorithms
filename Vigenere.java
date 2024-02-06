package CryptoLab;

import java.util.Scanner;

public class Vigenere {

        public static String encrypt(String plaintext, String key) {
            StringBuilder ciphertext = new StringBuilder();
            plaintext = plaintext.toUpperCase();
            key = key.toUpperCase();

            for (int i = 0, j = 0; i < plaintext.length(); i++) {
                char c = plaintext.charAt(i);
                if (Character.isLetter(c)) {
                    int shift = key.charAt(j % key.length()) - 'A';
                    char encryptedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                    ciphertext.append(encryptedChar);
                    j++;
                } else {
                    ciphertext.append(c);
                }
            }

            return ciphertext.toString();
        }

        public static String decrypt(String ciphertext, String key) {
            StringBuilder plaintext = new StringBuilder();
            ciphertext = ciphertext.toUpperCase();
            key = key.toUpperCase();

            for (int i = 0, j = 0; i < ciphertext.length(); i++) {
                char c = ciphertext.charAt(i);
                if (Character.isLetter(c)) {
                    int shift = key.charAt(j % key.length()) - 'A';
                    char decryptedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
                    plaintext.append(decryptedChar);
                    j++;
                } else {
                    plaintext.append(c);
                }
            }

            return plaintext.toString();
        }

        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            System.out.println("Enter Text:");
            String txt=in.nextLine();

            System.out.println("Enter Key:");
            String key=in.nextLine();

            String encryptedText = encrypt(txt, key);
            System.out.println("Encrypted: " + encryptedText);

            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted: " + decryptedText);
        }
}

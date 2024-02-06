package CryptoLab;


    import java.util.Scanner;

    public class RowColumn{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the plain text: ");
            String plainText = scanner.nextLine();

            System.out.print("Enter the key: ");
            String key = scanner.nextLine();

            // Encryption
            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Message:");
            System.out.println(encryptedText);

            // Decryption
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted Message:");
            System.out.println(decryptedText);

            scanner.close();
        }

        public static String encrypt(String plainText, String key) {
            String cleanedText = plainText.replaceAll("\\s", "").toUpperCase();
            int rows = (int) Math.ceil((double) cleanedText.length() / key.length());
            char[][] cipherMatrix = new char[rows][key.length()];
            int index = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < key.length(); j++) {
                    if (index < cleanedText.length()) {
                        cipherMatrix[i][j] = cleanedText.charAt(index++);
                    } else {
                        cipherMatrix[i][j] = '#';
                    }
                }
            }

            StringBuilder encryptedText = new StringBuilder();
            for (int j = 0; j < key.length(); j++) {
                int column = key.indexOf(String.valueOf(j + 1));
                for (int i = 0; i < rows; i++) {
                    encryptedText.append(cipherMatrix[i][column]);
                }
            }

            return encryptedText.toString();
        }

        public static String decrypt(String encryptedText, String key) {
            int rows = (int) Math.ceil((double) encryptedText.length() / key.length());
            char[][] cipherMatrix = new char[rows][key.length()];
            int index = 0;

            for (int j = 0; j < key.length(); j++) {
                int column = key.indexOf(String.valueOf(j + 1));
                for (int i = 0; i < rows; i++) {
                    if (index < encryptedText.length()) {
                        cipherMatrix[i][column] = encryptedText.charAt(index++);
                    }
                }
            }

            StringBuilder decryptedText = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < key.length(); j++) {
                    if (cipherMatrix[i][j] != '#') {
                        decryptedText.append(cipherMatrix[i][j]);
                    }
                }
            }

            return decryptedText.toString();
        }
    }



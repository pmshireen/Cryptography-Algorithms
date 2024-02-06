package CryptoLab;
import java.util.Scanner;
public class CaesarCipher {
        public static void main(String args[]){

            Scanner scanner=new Scanner(System.in);

            System.out.println("Enter message to encrypt");
            String message=scanner.nextLine();

            System.out.println("Enter encryption key");
            int key=scanner.nextInt();

            scanner.nextLine();
            String encryptedmessage = encrypt(message,key);
            System.out.println("Encryped message "+encryptedmessage);
            String decryptedmessage=decrypt(encryptedmessage,key);
            System.out.println("decryped message "+decryptedmessage);
            scanner.close();
        }
        public static String encrypt(String message,int key){
            StringBuilder result=new StringBuilder();
            for(int i=0;i<message.length();i++){
                char ch=message.charAt(i);
                if(Character.isLetter(ch)){
                    char base=Character.isUpperCase(ch)? 'A':'a';
                    ch=(char)(((ch-base+key)%26)+base);
//                    System.out.println(ch);
                }
                result.append(ch);
            }
            return result.toString();
        }
        public static String decrypt(String encryptedmessage,int key){
            int inversekey=(26-key)%26;
            return encrypt(encryptedmessage,inversekey);
        }
}




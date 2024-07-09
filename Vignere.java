package PP;

import java.awt.*;
import java.util.Scanner;

public class Vignere {
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

        public static String encrypt(String txt , String key){
        txt = txt.toUpperCase();
        key = key.toUpperCase();

        StringBuilder result = new StringBuilder();
        for(int i = 0,j = 0;i<txt.length();i++){
            char c = txt.charAt(i);
            if(Character.isLetter(c)){
                int shift = key.charAt(j%key.length()) - 'A';
                char ch = (char) (((c - 'A' + shift)%26)+ 'A');
                result.append(ch);
                j++;
            }
        }
        return result.toString();
    }

    public static String decrypt(String encTxt , String key){
        encTxt = encTxt.toUpperCase();
        key = key.toUpperCase();

        StringBuilder result1 = new StringBuilder();
        for(int i = 0,j = 0;i<encTxt.length();i++){
            char c = encTxt.charAt(i);
            if(Character.isLetter(c)){
                int shift = key.charAt(j%key.length()) - 'A';
                char ch = (char) (((c - 'A' - shift+26)%26 )+ 'A');
                j++;
                result1.append(ch);
            }
        }
        return result1.toString();
    }



}

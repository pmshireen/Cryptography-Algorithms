package PP;

import java.util.Scanner;
import java.security.*;
import javax.crypto.*;
public class DES {
    public static void main(String[] args) {

        try{

            KeyGenerator keygen = KeyGenerator.getInstance("DES");

            SecretKey mydesKey = keygen.generateKey();

            Cipher descipher;

            descipher = Cipher.getInstance("DES");

            Scanner sc = new Scanner(System.in);
            System.out.println("ENter String");
            String txt = sc.nextLine();

            byte[] plaintxt = txt.getBytes();

            descipher.init(Cipher.ENCRYPT_MODE,mydesKey);

            byte[] EncrytedText = descipher.doFinal(plaintxt);

            System.out.println("Encrypt Text "+EncrytedText);

            descipher.init(Cipher.DECRYPT_MODE,mydesKey);

            byte[] DecrytedText = descipher.doFinal(EncrytedText);

            System.out.println("Decrt:" +DecrytedText);



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

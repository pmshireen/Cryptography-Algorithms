package PP;
import java.io.*;
import java.security.*;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AES {
    private static  SecretKeySpec secretKey;
    private static byte[] key;

    public static void main(String[] args) {

        final String secretKey = "annaUniversity";

        String originalString = "murhsi";

        String encryptedString = Lab.AES.encrypt(originalString, secretKey);
        String decryptedString = Lab.AES.decrypt(encryptedString, secretKey);

        System.out.println("URL Encryption Using AES Algorithm\n");
        System.out.println("Original URL : " + originalString);
        System.out.println("Encrypted URL : " + encryptedString);
        System.out.println("Decrypted URL : " + decryptedString);
    }
    public static void setKey(String myKey){
        try{

            MessageDigest sha = MessageDigest.getInstance("AES");
            key  = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key , 16);
            secretKey = new SecretKeySpec(key , "AES");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static String encrypt(String msg , String secret){

        try {
            setKey(secret);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    public static String decrypt(String enryptedStringc , String secret){

        try {
            setKey(secret);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(enryptedStringc)));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }



}

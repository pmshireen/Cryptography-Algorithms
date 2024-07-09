package PP;

import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1 {

    public static void main(String[] args) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            Scanner sc = new Scanner(System.in);

            String txt = sc.nextLine();
            md.update(txt.getBytes());


            byte[] output = md.digest();

            System.out.println("Output " + bytesToHexOutput(output));
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    public static String bytesToHexOutput(byte[] b){
        char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        StringBuffer buf = new StringBuffer();

        for(byte aB: b){
            buf.append(hexDigit[((aB >> 4) & 0x0f)]);
            buf.append(hexDigit[(aB & 0x0f)]);
        }
        return buf.toString();
    }



}

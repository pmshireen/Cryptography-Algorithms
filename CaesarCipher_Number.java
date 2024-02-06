package CryptoLab;

import java.util.Scanner;

public class CaesarCipher_Number {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message");
        String msg=sc.nextLine();
        System.out.println("key:");
        int key=sc.nextInt();
        String emsg=encrypt(msg,key);
        System.out.println("Encrypted: "+emsg);
        String demsg=decrypt(emsg,key);
        System.out.println("Decrypted msg: "+demsg);
        sc.close();}
    public static String encrypt(String m,int k){
        StringBuilder r=new StringBuilder();
        for(int i=0;i<m.length();i++){
            char ch=m.charAt(i);
            if(Character.isLetter(ch)){
                char b=Character.isUpperCase(ch)?'A':'a';
                ch=(char)(((ch-b+k)%26)+b);
            }
            if(Character.isDigit(ch)){
                ch=(char)((ch-'0'+k)%10+'0');
            }
            r.append(ch);}
        return r.toString();}
    public static String decrypt(String mm,int kk){
        StringBuilder r=new StringBuilder();
        for(int i=0;i<mm.length();i++){
            char ch=mm.charAt(i);
            if(Character.isLetter(ch)){
                int kkk=(26-kk)%26;
                char b=Character.isUpperCase(ch)?'A':'a';
                ch=(char)(((ch-b+kkk)%26)+b);
            }
            if(Character.isDigit(ch)){
                int kkk=(10-kk)%10;
                ch=(char)((ch-'0'+kkk)%10+'0');
            }
            r.append(ch);}
        return r.toString();

    }
}

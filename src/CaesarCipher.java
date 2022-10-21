
import java.util.Scanner;


public class CaesarCipher {
    
    static String alphabet = "abcçdefgğhıijklmnoöprsştuüvyz";
    
    public static String encoding(String pText, int Key){
        
        pText = pText.toLowerCase();
        String cText = "";
        
        for(int i=0; i<pText.length();i++)
        {
            int charIndex = alphabet.indexOf(pText.charAt(i));
            int newIndex = (charIndex + Key) % 29;
            char cipherChar = alphabet.charAt(newIndex);
            cText = cText + cipherChar;
        }
        return cText;
    }
    
    public static String decoding(String cText, int Key){
         cText = cText.toLowerCase();
         String pText = "";
         
         for(int i = 0; i<cText.length(); i++)
         {
             int charIndex = alphabet.indexOf(cText.charAt(i));
             int newIndex = (charIndex - Key) % 29;
             if(newIndex<0){
                 newIndex = alphabet.length() + newIndex;
             }
             char plainChar = alphabet.charAt(newIndex);
             pText = pText + plainChar;
         }
         
         return pText;        
    }
    
    public static void main (String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the plain text: ");
        String plain = scanner.nextLine();
        
        System.out.print("Enter the key: ");
        int Key = scanner.nextInt();
        
        String cipherText = encoding(plain, Key);
        System.out.println("The cipher text: " +cipherText);
        System.out.println("The decoded message is: " +decoding(cipherText, Key));
        
    }
}

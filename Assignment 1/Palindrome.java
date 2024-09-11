
import java.util.Scanner;

public class Palindrome {

    static String revStr(String str) {
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr += str.charAt(i);
        }
        return revStr;
    }

    static boolean checkPalindrome(String str) {
        return revStr(str).equalsIgnoreCase(str);
        // return revStr(str).equals(str);
    }

    public static void main(String[] args) {
        System.out.println("\n<--- Program for checking Palindrome --->");
        System.out.print("\nEnter the String : ");
        Scanner myobj = new Scanner(System.in);
        String str = myobj.next();
        if (checkPalindrome(str)) {
            System.out.println("\nThe entered String '" + str + "' is a Palindrome.");
        } else {
            System.out.println("\nThe entered String '" + str + "' is not a Palindrome.");
        }System.out.println("");
    }
}

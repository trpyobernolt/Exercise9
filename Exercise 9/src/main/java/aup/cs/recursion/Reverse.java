package aup.cs.recursion;

public class Reverse {

    public static void reverseDisplay(String value){
        reverseDisplayHelper(value, value.length() - 1);
    }

    private static void reverseDisplayHelper(String value, int length) {
        if(length == -1) {
            return;
        }
        System.out.print(value.charAt(length));
        reverseDisplayHelper(value, length - 1);
    }

}

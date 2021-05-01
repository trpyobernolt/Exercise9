package aup.cs.recursion;

public class CharCounter {
    public static int count(String str, char a) {
        int tot = 0;
        if (str.equals("")) {
            return 0;
        }
        if(str.charAt(0) == a) {
            tot += 1;
        }
        String cut = str.substring(1);
        return tot + count(cut, a);
        }
    }

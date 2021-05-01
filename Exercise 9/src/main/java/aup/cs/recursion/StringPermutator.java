package aup.cs.recursion;

public class StringPermutator {
    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }
    private static void displayPermutation(String s1, String s2) {
        if(s2.equals("")) {
            System.out.print(s1 + " ");
        }
        else {
                for (int i = 0; i < s2.length(); i++) {
                    StringBuilder s1Build = new StringBuilder(s1);
                    StringBuilder s2Build = new StringBuilder(s2);
                    char toMove = s2.charAt(i);
                    s1Build.append(toMove);
                    s2Build.deleteCharAt(i);
                    displayPermutation(s1Build.toString(), s2Build.toString());
                }
            }
        }
    }

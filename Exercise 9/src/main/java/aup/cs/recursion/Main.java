package aup.cs.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.reverseDisplay("Hello World");
        System.out.print("\n");
        CharCounter charCounter = new CharCounter();
        System.out.println("The character e appears " + charCounter.count("Welcome", 'e') + " times in welcome");
        StringPermutator permutator = new StringPermutator();
        permutator.displayPermutation("abc");
        System.out.print("\n");
        int[] listTrue = {3, 7, 1, 8, -3};
        System.out.println(subsetProblem(listTrue, 4));
        int[] listFalse = {1, 2};
        System.out.println(subsetProblem(listFalse, 4));
        int[] puzzle1 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 0};
        System.out.println("Can we solve " + Arrays.toString(puzzle1) + " At pos 0? " + solvePuzzle(0, puzzle1));
        int[] puzzle2 = {3, 1, 2, 3, 0};
        System.out.println("Can we solve " + Arrays.toString(puzzle2) + " At pos 0? " + solvePuzzle(0, puzzle2));
        int[] puzzle3 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 0};
        System.out.println("Can we solve " + Arrays.toString(puzzle3) + " At pos 3? " + solvePuzzle(3, puzzle3));
        int[] puzzle4 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 0};
        System.out.println("Can we solve " + Arrays.toString(puzzle4) + " At pos 2? " + solvePuzzle(2, puzzle3));
    }


    public static boolean subsetProblem(int[] arr, int target) {
        return (subsetHelper(arr, arr.length, target));
    }

    private static boolean subsetHelper(int[] arr, int n, int sum) {
        //Base Cases
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        if (arr[n - 1] > sum) {
            subsetHelper(arr, n - 1, sum);
        }
        return (subsetHelper(arr, n - 1, sum) || subsetHelper(arr, n - 1, sum - arr[n - 1]));
    }

    public static boolean solvePuzzle(int pos, int[] puzzle) {
        return puzzleHelper(pos, puzzle, new LinkedList());
    }

    private static boolean puzzleHelper(int pos, int[] puzzle, LinkedList history) {
        int goal = puzzle.length - 1;
        int moveVal = puzzle[pos];

        //Base Case
        try {
            if (goal == pos + moveVal) {
                history.add("Move Right");
                //System.out.println(history.toString());
                return true;
            }
            else {
                if(pos-moveVal >= 0 && pos+moveVal < goal){
                    return(puzzleHelper(pos-moveVal, puzzle, history) || puzzleHelper(pos+moveVal, puzzle, history));
                }
                if(pos+moveVal < goal) {
                    history.add("Move Right");
                    return(puzzleHelper(pos+moveVal, puzzle, history));
                }
                if(pos-moveVal >= 0) {
                    history.add("Move Left");
                    return puzzleHelper(pos-moveVal, puzzle, history);
                }
            }
        }
        catch (StackOverflowError SOE) {
            return false;
        }
        return false;
    }
}



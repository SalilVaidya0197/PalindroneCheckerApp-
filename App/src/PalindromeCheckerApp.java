import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean reverseMethod(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        return str.equals(reversed);
    }

    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean twoPointerMethod(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        reverseMethod(input);
        endTime = System.nanoTime();
        System.out.println("Reverse Method Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        stackMethod(input);
        endTime = System.nanoTime();
        System.out.println("Stack Method Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        twoPointerMethod(input);
        endTime = System.nanoTime();
        System.out.println("Two Pointer Method Time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}
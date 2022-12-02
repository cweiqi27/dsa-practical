package queueApplications;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Palindrome {
    // Stack
  static boolean isPalindromeUsingStack(String phrase) {
    Stack<String> stack = new Stack<>();
    StringBuilder alphaOnlyStr = new StringBuilder();
    StringBuilder reversedStr = new StringBuilder();

    for(int i = 0; i < phrase.length(); i++) {
      String charToStr = String.valueOf(phrase.charAt(i));

      if(charToStr.matches("[a-zA-Z]+")) {
        stack.push(charToStr);
        alphaOnlyStr.append(charToStr);
      }
    }

    int phraseLength = stack.size();

    for(int i = 0; i < phraseLength; i++)
      reversedStr.append(stack.pop());

    return alphaOnlyStr.toString().equalsIgnoreCase(reversedStr.toString());
  }

  static boolean isPalindromeUsingQueue(String phrase) {
    Deque<String> deque = new LinkedList<>();
    StringBuilder alphaOnlyStr = new StringBuilder();
    StringBuilder reversedStr = new StringBuilder();

    for(int i = phrase.length() - 1; i >= 0; i--) {
      String charToStr = String.valueOf(phrase.charAt(i));

      if(charToStr.matches("[a-zA-Z]+")) {
        deque.add(charToStr);
        alphaOnlyStr.append(charToStr);
      }
    }

    int phraseLength = deque.size();

    for(int i = 0; i < phraseLength; i++) {
      reversedStr.append(deque.removeLast());
    }

    return alphaOnlyStr.toString().equalsIgnoreCase(reversedStr.toString());
  }

  public static void main(String[] args) {
    HashMap<Integer, String> testCase = new HashMap<>();
    testCase.put(1, "Racecar");
    testCase.put(2, "A Man, A Plan, A Canal... Panama!");
    testCase.put(3, "asdhjksv7uihvsdf");
    testCase.put(4, "raceCar");
    testCase.put(5, "r A c, e caR");

    System.out.println("Using stack:");
    System.out.println(isPalindromeUsingStack(testCase.get(1)));
    System.out.println(isPalindromeUsingStack(testCase.get(2)));
    System.out.println(isPalindromeUsingStack(testCase.get(3)));
    System.out.println(isPalindromeUsingStack(testCase.get(4)));
    System.out.println(isPalindromeUsingStack(testCase.get(5)));

    System.out.println("\nUsing queue:");
    System.out.println(isPalindromeUsingQueue(testCase.get(1)));
    System.out.println(isPalindromeUsingQueue(testCase.get(2)));
    System.out.println(isPalindromeUsingQueue(testCase.get(3)));
    System.out.println(isPalindromeUsingQueue(testCase.get(4)));
    System.out.println(isPalindromeUsingQueue(testCase.get(5)));
  }
}

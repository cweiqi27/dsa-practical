package maths;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    BracketsPair bracketsPair = new BracketsPair();
    PostfixEvaluation postfixEvaluation = new PostfixEvaluation();

    // Question 3
    HashMap<Integer, String> testCaseQ3 = new HashMap<>();
    testCaseQ3.put(1, "(){}");
    testCaseQ3.put(2, "({})");
    testCaseQ3.put(3, "(){}[]");
    testCaseQ3.put(4, "(){");
    testCaseQ3.put(5, "[{()}]");

    System.out.println("Question 3: ");
    for(int i = 1; i < testCaseQ3.size() + 1; i++)
      System.out.println(testCaseQ3.get(i) + " => " + bracketsPair.isBalanced(testCaseQ3.get(i)));

    // Question 4
    HashMap<Integer, String> testCaseQ4 = new HashMap<>();
    testCaseQ4.put(1, "62+53*/");
    testCaseQ4.put(2, "125-6712/*");
    testCaseQ4.put(3, "125-6712/*");
    testCaseQ4.put(4, "125-6712/*");
    testCaseQ4.put(5, "125-6712/*");

    System.out.println("\nQuestion 4: ");
    for(int i = 1; i < testCaseQ4.size() + 1; i++)
      System.out.println("Postfix: " + testCaseQ4.get(i) + " => Answer: " + postfixEvaluation.evaluatePostfix(testCaseQ4.get(i)));
  }
}

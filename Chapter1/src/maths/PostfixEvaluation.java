package maths;

import java.util.Objects;
import java.util.Stack;

public class PostfixEvaluation {
  public String evaluatePostfix(String postfix) {
    Stack<String> stack = new Stack<>();

    for(int i = 0; i < postfix.length(); i++) {
      String arithmeticVar = Character.toString(postfix.charAt(i));
      String isOperandRegex = "[0-9]+";

      if(stack.empty() || arithmeticVar.matches(isOperandRegex))
        stack.push(arithmeticVar);

      if(isOperator(arithmeticVar)) {
        double y = Double.parseDouble(stack.pop());
        double x = Double.parseDouble(stack.pop());
        stack.push(operateMath(arithmeticVar, x ,y));
      }
    }

    return stack.pop();
  }

  private boolean isOperator(String arithmeticVar) {
    return Objects.equals(arithmeticVar, "+") | Objects.equals(arithmeticVar, "-") ||
            Objects.equals(arithmeticVar, "*") || Objects.equals(arithmeticVar, "/");
  }

  private String operateMath(String arithmeticVar, double x, double y) {
    double res;

    if (Objects.equals(arithmeticVar, "+")) {
      res = x + y;
    } else if(Objects.equals(arithmeticVar, "-")) {
      res = x - y;
    } else if(Objects.equals(arithmeticVar, "*")) {
      res = x * y;
    } else {
      res = x / y;
    }

    String doubleStr = Double.toString(Math.abs(res));
    int integerPlaces = doubleStr.indexOf(".");
    int decimalPlaces =  doubleStr.length() -  integerPlaces -1;

    return decimalPlaces > 2
            ? String.format("%.2f", res)
            : doubleStr;
  }
}

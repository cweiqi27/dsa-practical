package maths;

import java.util.HashMap;
import java.util.Stack;

public class BracketsPair {
  public boolean isBalanced(String brackets) {
    Stack<Character> stack = new Stack<>();
    HashMap<Character, Character> pair = new HashMap<>();
    pair.put('(', ')');
    pair.put('[', ']');
    pair.put('{', '}');

    int bracketsLength = brackets.length();

    for(int i = 0; i < bracketsLength; i++) {
      char bracket = brackets.charAt(i);
      if(stack.isEmpty())
        stack.push(bracket);
      else {
        if(pair.containsKey(bracket))
          stack.push(bracket);
        else if(pair.containsValue(bracket) && pair.get(stack.peek()) == bracket)
          stack.pop();
        else
          return false;
      }
    }

    return stack.isEmpty();
  }
}

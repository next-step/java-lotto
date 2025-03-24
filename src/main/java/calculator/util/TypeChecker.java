package calculator.util;

import calculator.type.OperatorType;

public class TypeChecker {

  public static boolean isOperatorType(String str) {
    try {
      OperatorType.fromSymbol(str);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}

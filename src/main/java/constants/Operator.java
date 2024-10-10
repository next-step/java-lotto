package constants;

import java.util.Arrays;

public enum Operator {
      PLUS("PLUS", "+")
    , MINUS("MINUS", "-")
    , MULTIPLICATION("MULTIPLICATION", "*")
    , DIVISION("DIVISION", "/");

      private final String code;
      private final String operator;

      Operator(String code, String operator) {
          this.code = code;
          this.operator = operator;
      }

    public String getCode() {
        return code;
    }

    public String getOperator() {
        return operator;
    }

    static public Operator find(String value) {
          return Arrays.stream(values())
                  .filter(operator -> operator.getOperator().equals(value))
                  .findAny()
                  .orElse(null);
    }
}

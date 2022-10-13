package domain;

public enum Operator {
  PLUS("+"){
    @Override
    public int calculate(int num1,int num2){
      return num1 + num2;
    }
  },
  MINUS("-"){
    @Override
    public int calculate(int num1,int num2){
      return num1 - num2;
    }
  },
  MULTIPLY("*"){
    @Override
    public int calculate(int num1,int num2){
      return num1 * num2;
    }
  },
  DIVIDE("/"){
    @Override
    public int calculate(int num1,int num2){
      ExpressionValidation.validateDenominator(num2);
      return num1 / num2;
    }
  }
  ;

  private final String Operator;

  Operator(final String Operator) {
    this.Operator = Operator;
  }
  public abstract int calculate(int num1, int num2);
}

package model;

public class CalculatorImpl implements Calculator {
    private Operator operator;

    public CalculatorImpl(Operator operator) {
        this.operator = operator;
    }


    @Override
    public int calculate(int num1, int num2, String operator) {
        int res;
        switch(operator){
            case "+" :
                res = this.operator.add(num1, num2);
                break;
            case "-" :
                res = this.operator.minus(num1 ,num2);
                break;
            case "*":
                res = this.operator.multiply(num1, num2);
                break;
            case "/":
                res = this.operator.divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return res;
    }
}

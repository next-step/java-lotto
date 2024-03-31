package calculator.calc;

public class Calculator {

    public int add(int a, int b){
        return a + b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
    public int minus(int a, int b){
        return a - b;
    }
    public int divide(int a, int b){
        return a/b;
    }

    public int calc(String[] addExpression){
        String aString = addExpression[0];
        String opString = addExpression[1];
        String bString = addExpression[2];

        int a = Integer.parseInt(aString);
        int b = Integer.parseInt(bString);

        if(opString.equals("+")) return this.add(a, b);
        if(opString.equals("*")) return this.mul(a, b);
        if(opString.equals("-")) return this.minus(a, b);
        if(opString.equals("/")) return this.divide(a, b);
        throw new IllegalArgumentException();
    }
}

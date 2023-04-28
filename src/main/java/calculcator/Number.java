package calculcator;

public class Number {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number calculate(Operator operator, int target){
        return new Number(operator.apply(number,target));
    }

    public int getNumber() {
        return number;
    }
}

package stringcalculator;

public class MinusCommand implements Command {

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.minus(rightNumber);
    }
}

package stringcalculator;

public class AddCommand implements Command {

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.add(rightNumber);
    }
}

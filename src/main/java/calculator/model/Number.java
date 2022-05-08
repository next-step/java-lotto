package calculator.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number {
    private final Pattern NUMBER_PATTERN = Pattern.compile("[^-][0-9]*");
    private final int number;

    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    private void validate(String number){
        if(number == null || !NUMBER_PATTERN.matcher(number).matches()){
            throw new IllegalArgumentException(number+":0이상의 숫자가 아닙니다");
        }
    }

    public Number calculate(Operator op, Number number){
        return new Number(String.valueOf(op.calculate(this.number, number.getNumber())));
    }

    public int getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        return ((Number) o).getNumber() == getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

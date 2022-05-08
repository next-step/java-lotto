package domain;

import java.util.Objects;

public class Operand {

    private Integer number;

    public Operand(Integer number) {
        this.number = number;
    }

    public Operand(String number) {
        this(Integer.parseInt(number));
    }

    public static boolean isOperand(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public Operand plus(Operand operand){
        return new Operand(number + operand.number);
    }

    public Operand minus(Operand operand){
        return new Operand(number - operand.number);
    }

    public Operand multiple(Operand operand){
        return new Operand(number * operand.number);
    }

    public Operand divide(Operand operand){
        return new Operand(number / operand.number);
    }

    @Override
    public boolean equals(Object o) {
        try {
            if((int)o == number){
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand = (Operand) o;
        return Objects.equals(number, operand.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getValue() {
        return number;
    }
}

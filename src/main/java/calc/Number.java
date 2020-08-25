package calc;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(){
        this.number = 0;
    }

    public Number(int num){
        this.number = num;
    }

    public Number(String string){
        try{
            this.number = Integer.parseInt(string);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(string+" cannot conver to number");
        }

        if(this.number < 0) {
            throw new IllegalArgumentException("negative number cannot be used");
        }
    }

    public Number add(Number addNumber){
        return new Number(this.getNumber()+addNumber.getNumber());
    }

    public int getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

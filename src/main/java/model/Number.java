package model;

import java.util.Objects;

public class Number {
    private final String NUMBER_PATTERN = "[^-][0-9]*";

    private final int number;


    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    private void validate(String number){
        if(number == null || !number.matches(NUMBER_PATTERN)){
            throw new IllegalArgumentException(number+":0이상의 숫자가 아닙니다");
        }
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

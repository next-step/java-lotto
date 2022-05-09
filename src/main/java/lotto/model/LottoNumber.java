package lotto.model;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String strNumber) {
        int number = Integer.parseInt(strNumber);
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 수입니다.");
        }
    }

    private int getNumber(){
        return this.number;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        return ((LottoNumber) o).getNumber() == getNumber();
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}

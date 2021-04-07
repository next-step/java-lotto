package lotto.domain;

import java.util.List;

public class LottoNumber {

    private List<Number> numbers;
    private final Number One = new Number(1);
    private final Number fortyFive = new Number(45);
    public LottoNumber(List<Number> numbers) {
        this.numbers = numbers;
        checkNumber();
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    private void checkNumber(){
        for(Number number : this.numbers){
            exceedCheckNumber(number);
        }
    }

    private void exceedCheckNumber(Number number){
        if(One.number() > number.number()  || number.number() > fortyFive.number()){
            throw new IllegalArgumentException("입력할수 있는 숫자범위를 넘었습니다.(1~45)");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (Number number : this.numbers) {
            output.append(number.number() + ",");
        }
        output.delete(output.length() - 1, output.length());
        output.append("]");
        return output.toString();
    }
}

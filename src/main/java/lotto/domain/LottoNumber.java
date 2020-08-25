package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if(number < 0 || number > 45) throw new IllegalArgumentException("LottoNumber is out of range[0-45]");
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public String getNumberString() {
        return Integer.toString(number);
    }

    public static List<LottoNumber> makeLottoNums(String[] arr){
        List<LottoNumber> numbers = new ArrayList<>();
        for(String s : arr){
            s = s.replaceAll(" ","");
            numbers.add(new LottoNumber(Integer.parseInt(s)));
        }

        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

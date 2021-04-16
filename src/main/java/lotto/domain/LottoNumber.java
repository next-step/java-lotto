package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoNumber {

    private List<Number> numbers;
    private static final int LOTTO_SIZE = 6;

    public LottoNumber(Set<Integer> numbers){
        this(changeSetToList(numbers));
    }

    public LottoNumber(List<Number> numbers) {
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또는 6자리 숫자를 입력해야합니다.");
        }
        this.numbers = numbers;
    }

    private static List<Number> changeSetToList(Set<Integer> numbers){
        List<Number> changedNumberList = new ArrayList<>();
        for(Integer inputNumber : numbers){
            Number number = new Number(inputNumber);
            changedNumberList.add(number);
        }
        return changedNumberList;
    }

    public List<Number> numbers() {
        return this.numbers;
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

package stringCalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Numbers {
    public List<Integer> numbers = new ArrayList<>();

    public Numbers() {};

    public void addNumber(String inputNumber) {
        validNumber(inputNumber);
        numbers.add(Integer.parseInt(inputNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public Integer getFirstNumber() { return numbers.get(0); }


    public void validNumber(String inputNumber) {
        if(!Pattern.matches("^[0-9]*$", inputNumber)) {
            throw new IllegalArgumentException("숫자가 입력되어야 할 자리에 숫자를 입력해주세요");
        }
    }

}

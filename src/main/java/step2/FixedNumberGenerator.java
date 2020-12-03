package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixedNumberGenerator extends LottoGenerator {
    public static final List<Integer> numbers = new ArrayList<>();

    public void setNumber(String inputNumber) {
        for (String i : inputNumber.split(",")) {
            numbers.add(Integer.parseInt(i));
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.sort(numbers);
        return numbers;
    }
}

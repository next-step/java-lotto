package step3;

import java.util.ArrayList;
import java.util.List;

public class FixedNumberGenerator extends LottoGenerator {
    public static final List<LottoNumber> numbers = new ArrayList<>();

    public void setNumber(String inputNumber) {
        for (String i : inputNumber.split(",")) {
            numbers.add(new LottoNumber(Integer.parseInt(i)));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }
}

package step4;

import step4.VO.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class FixedNumberGenerator extends LottoGenerator {
    public final List<LottoNumber> numbers = new ArrayList<>();

    public void setNumber(String inputNumber) {
        for (String i : inputNumber.split(",")) {
            numbers.add(new LottoNumber(Integer.parseInt(i)));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }
}

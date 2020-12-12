package step4;

import step4.VO.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int lottoSize = 6;
    public final List<LottoNumber> numbers;

    public LottoGenerator(){
        numbers = new ArrayList<>();

        for (int i = 1; i <= LottoNumber.maxNumber; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoSize ; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

}

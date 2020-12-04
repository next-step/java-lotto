package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public final List<Integer> numbers;

    public LottoGenerator(){
        numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            lottoNumbers.add(new LottoNumber(numbers.get(i)));
        }
        return lottoNumbers;
    }

}

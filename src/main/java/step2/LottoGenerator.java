package step2;

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

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}

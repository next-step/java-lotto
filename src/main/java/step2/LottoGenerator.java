package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator implements Generator {
    private final List<Integer> numbers = new ArrayList<>();

    public void setNumber(String inputNumber) {
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

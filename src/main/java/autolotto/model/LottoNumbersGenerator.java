package autolotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {

    private static final List<Integer> numbers = new ArrayList<>();
    static {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public static void setLottoNumbers(List<Integer> lottoNumbers){
        Collections.shuffle(numbers);

        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }

        Collections.sort(lottoNumbers);
    }
}

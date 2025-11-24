package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}

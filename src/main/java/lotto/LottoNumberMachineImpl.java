package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberMachineImpl implements LottoNumberMachine {

    private static final int LOTTO_NUMBERS_COUNT = 6;

    @Override
    public List<Number> lottoNumbers() {
        List<Number> numbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_SOURCE);

        for(int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            numbers.add(LOTTO_NUMBER_SOURCE.get(i));
        }

        Collections.sort(numbers);
        return numbers;
    }

}

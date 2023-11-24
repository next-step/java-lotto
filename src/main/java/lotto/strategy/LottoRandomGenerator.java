package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator implements LottoGenerator {

    @Override
    public List<Integer> generate(int minLottoNumber, int maxLottoNumber, int lottoNumberCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int number = minLottoNumber; number <= maxLottoNumber; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, lottoNumberCount);
        Collections.sort(numbers);

        return numbers;
    }

}

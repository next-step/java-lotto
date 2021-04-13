package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator{
    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumberGenerator.lottoMinNumber; i <= LottoNumberGenerator.lottoMaxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LottoNumberGenerator.lottoNumberCount);
        return numbers;
    }
}

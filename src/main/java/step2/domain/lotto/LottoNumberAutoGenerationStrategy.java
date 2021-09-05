package step2.domain.lotto;

import step2.vo.LottoNumberValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberAutoGenerationStrategy implements LottoNumberGenerationStrategy{
    private final List<Integer> LOTTO_NUMBER_VALUES =
            IntStream.rangeClosed(LottoNumberValue.MIN.value, LottoNumberValue.MAX.value)
            .boxed()
            .sorted()
            .collect(Collectors
                    .toList());

    @Override
    public int generateNumber() {
        List<Integer> copiedLottoNumberValues = new ArrayList<>(LOTTO_NUMBER_VALUES);
        Collections.shuffle(copiedLottoNumberValues);
        return copiedLottoNumberValues.get(0);
    }
}

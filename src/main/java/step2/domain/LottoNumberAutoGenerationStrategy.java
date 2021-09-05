package step2.domain;

import step2.vo.LottoNumberVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberAutoGenerationStrategy implements LottoNumberGenerationStrategy{
    private final List<Integer> LOTTO_NUMBER_VALUES =
            IntStream.rangeClosed(LottoNumberVO.MIN.value, LottoNumberVO.MAX.value)
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

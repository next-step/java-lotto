package lotto.domain.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int CHOICE_START_INDEX = 0;
    private static final int CHOICE_END_INDEX = 6;

    @Override
    public List<Integer> generate() {

        List<Integer> lottoNumberPool = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberPool);
        List<Integer> chosenLottoNumber = choiceLottoNumbers(lottoNumberPool);
        sortLottoNumberAsc(chosenLottoNumber);

        return chosenLottoNumber;
    }

    private List<Integer> choiceLottoNumbers(List<Integer> lottoNumberPool) {

        return lottoNumberPool.subList(CHOICE_START_INDEX, CHOICE_END_INDEX);
    }

    private void sortLottoNumberAsc(List<Integer> lottoNumbers) {

        lottoNumbers.sort(Integer::compareTo);
    }
}

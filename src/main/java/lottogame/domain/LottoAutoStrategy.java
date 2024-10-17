package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoStrategy implements LottoStrategy {
    private final List<LottoNumber> NUMBER_POOL = IntStream.rangeClosed(LottoGameConstants.MIN_LOTTO_NUMBER, LottoGameConstants.MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public LottoNumbers generateLottoNumbers() {
        List<LottoNumber> shuffledNumbers = new ArrayList<>(NUMBER_POOL);
        Collections.shuffle(shuffledNumbers);

        return new LottoNumbers(shuffledNumbers.subList(0, LottoGameConstants.LOTTO_NUMBER_COUNT));
    }

}


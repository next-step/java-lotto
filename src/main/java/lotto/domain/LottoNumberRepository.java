package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberRepository {
    private static final int INITIAL_INDEX = 0;
    private static final int TOTAL_LENGTH = 6;

    private final List<LottoNumber> lottoNumber = new ArrayList<>();

    public LottoNumberRepository() {
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            lottoNumber.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getAutoLottoNumbers() {
        List<LottoNumber> randomNumbers = getRandonNumbers();
        return randomNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::number))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> getRandonNumbers() {
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(INITIAL_INDEX, TOTAL_LENGTH);
    }
}

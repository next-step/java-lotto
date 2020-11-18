package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersCreateStrategy implements LottoNumbersCreateStrategy {
    private static final RandomNumberCreateStrategy createRandomNumberStrategy = new RandomNumberCreateStrategy();

    @Override
    public LottoNumbers create() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.isEmpty() || LottoNumbers.hasDuplicates(lottoNumbers)) {
            lottoNumbers = createRandomNumbers();
        }
        return LottoNumbers.of(lottoNumbers);
    }

    private List<LottoNumber> createRandomNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBERS_LENGTH; i++) {
            lottoNumbers.add(createRandomNumberStrategy.create());
        }
        return lottoNumbers;
    }
}

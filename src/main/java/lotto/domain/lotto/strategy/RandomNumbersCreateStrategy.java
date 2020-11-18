package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBERS_LENGTH;

public class RandomNumbersCreateStrategy implements LottoNumbersCreateStrategy {
    private static final RandomNumberCreateStrategy createRandomNumberStrategy = new RandomNumberCreateStrategy();

    @Override
    public List<LottoNumber> create() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.isEmpty() || LottoTicket.hasDuplicates(lottoNumbers)) {
            lottoNumbers = createRandomNumbers();
        }
        return lottoNumbers;
    }

    private List<LottoNumber> createRandomNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS_LENGTH; i++) {
            lottoNumbers.add(createRandomNumberStrategy.create());
        }
        return lottoNumbers;
    }
}

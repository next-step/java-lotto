package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersCreateStrategy implements LottoNumbersCreateStrategy {
    private static final RandomNumberCreateStrategy createRandomNumberStrategy = new RandomNumberCreateStrategy();

    @Override
    public List<LottoNumber> create(final LottoNumber bonusNumber) {
        final int lottoNumberLength = LottoTicket.getLottoNumbersLength();
        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberLength);
        while (lottoNumbers.isEmpty() || LottoTicket.hasDuplicates(lottoNumbers, bonusNumber)) {
            lottoNumbers = createRandomNumbers(lottoNumberLength);
        }
        return lottoNumbers;
    }

    private List<LottoNumber> createRandomNumbers(final int lottoNumberLength) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberLength);
        for (int i = 0; i < lottoNumberLength; i++) {
            lottoNumbers.add(createRandomNumberStrategy.create());
        }
        return lottoNumbers;
    }
}

package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class CreateRandomNumbersStrategy implements CreateLottoNumbersStrategy {
    private static final CreateRandomNumberStrategy createRandomNumberStrategy = new CreateRandomNumberStrategy();

    @Override
    public List<LottoNumber> create() {
        final int lottoNumberLength = Lotto.getLottoNumbersLength();
        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberLength);
        while (lottoNumbers.isEmpty() || Lotto.hasDuplicates(lottoNumbers)) {
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

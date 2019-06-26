package lotto.domain;

import lotto.domain.generator.LottoNumbersGenerator;
import lotto.domain.generator.ManualLottoNumberGenerator;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class WinningNumbers {
    private LottoNumbers lottoNumbers;

    public WinningNumbers(List<Integer> numbers) {
        LottoNumbersGenerator generator = new ManualLottoNumberGenerator(numbers);
        this.lottoNumbers = new LottoNumbers(generator);
    }

    public boolean contains(int number) {
        return contains(new LottoNumber(number));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.getLottoNumbers().contains(lottoNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }
}

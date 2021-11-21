package lotto.domain.numbergenerator;

import lotto.domain.LottoNumber;
import lotto.exception.LottoNumbersCountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator implements LottoNumbersGenerator {

    private final List<LottoNumber> lottoNumbers;

    private ManualLottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersCount(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public void validateLottoNumbersCount(int count) {
        if (count != 6) {
            throw new LottoNumbersCountException(count);
        }
    }

    public static ManualLottoNumbersGenerator from(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .mapToObj(LottoNumber::from)
                .sorted()
                .collect(Collectors.toList());

        return new ManualLottoNumbersGenerator(lottoNumbers);
    }

    @Override
    public List<LottoNumber> generate() {
        return lottoNumbers;
    }

}

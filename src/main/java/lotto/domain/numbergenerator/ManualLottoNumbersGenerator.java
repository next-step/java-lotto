package lotto.domain.numbergenerator;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator extends AbstractNumberGenerator {
    private final List<LottoNumber> lottoNumbers;

    private ManualLottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersCount(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }


    public static ManualLottoNumbersGenerator from(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .mapToObj(LottoNumber::from)
                .sorted()
                .collect(Collectors.toList());

        return new ManualLottoNumbersGenerator(lottoNumbers);
    }

    public List<LottoNumber> generate() {
        return lottoNumbers;
    }
}

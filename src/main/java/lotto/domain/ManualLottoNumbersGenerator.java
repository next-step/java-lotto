package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator implements LottoNumbersGenerator {

    private final List<LottoNumber> lottoNumbers;

    private ManualLottoNumbersGenerator(String[] numbers) {
        this.lottoNumbers = Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .mapToObj(LottoNumber::from)
                .sorted()
                .collect(Collectors.toList());
    }

    public static ManualLottoNumbersGenerator from(String[] numbers) {
        return new ManualLottoNumbersGenerator(numbers);
    }

    @Override
    public List<LottoNumber> generate() {
        return lottoNumbers;
    }
}

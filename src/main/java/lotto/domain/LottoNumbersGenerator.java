package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    public static final String SPLIT_DELIMITER = ",";
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbersGenerator() {
        for (int i = LottoNumber.LOTTO_NUMBER_MIN; i <= LottoNumber.LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers generateRandomLottoNumbers() {
        Collections.shuffle(this.lottoNumbers);
        List<LottoNumber> resultLottoNumbers = this.lottoNumbers.stream()
                .limit(LottoNumbers.LOTTO_NUMBERS_COUNT)
                .sorted()
                .collect(Collectors.toList());
        return new LottoNumbers(resultLottoNumbers);
    }

    public LottoNumbers toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(SPLIT_DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return new LottoNumbers(lottoNumbers);
    }
}

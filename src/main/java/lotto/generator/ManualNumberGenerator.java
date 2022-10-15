package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManualNumberGenerator implements NumberGenerator {

    private String numbers;

    public ManualNumberGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> generate() {
        String[] splitNumbers = numbers.split(", ");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUM; i < MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(LottoNumber.from(Integer.parseInt(splitNumbers[i])));
        }
        return lottoNumbers;
    }
}

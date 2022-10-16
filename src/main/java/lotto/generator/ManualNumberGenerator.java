package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberGenerator implements NumberGenerator {

    private String numbers;

    public ManualNumberGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> generate() {
        String[] splitNumbers = numbers.split(", ");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUM_COUNT; i < MAX_LOTTO_NUM_COUNT; i++) {
            lottoNumbers.add(LottoNumber.from(Integer.parseInt(splitNumbers[i])));
        }
        return lottoNumbers;
    }
}

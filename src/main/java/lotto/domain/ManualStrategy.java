package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualStrategy implements GeneratorStrategy {
    public static final String REGEX = ",";
    private final String input;

    public ManualStrategy(String input) {
        this.input = input;
    }

    @Override
    public Lotto generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : input.split(REGEX)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return new Lotto(lottoNumbers);
    }
}

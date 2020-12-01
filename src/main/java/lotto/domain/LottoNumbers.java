package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int NUMBER_RANGE = 6;
    public static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private final List<LottoNumber> value;

    public LottoNumbers(List<LottoNumber> value) {
        this.value = value;
    }

    public LottoNumbers(String winningNumbers) {
        value = lottoNumberGenerator.create(winningNumbers);
    }

    public Rank getRank(LottoNumbers lottoNumbers) {

        int matchingNumberCount = (int) value.stream()
                .filter(lottoNumber -> lottoNumbers.getIntegerValues()
                        .contains(lottoNumber.getValue()))
                .count();

        return Rank.value(matchingNumberCount);
    }

    public List<Integer> getIntegerValues() {
        return value.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getValue() {
        return value;
    }


}

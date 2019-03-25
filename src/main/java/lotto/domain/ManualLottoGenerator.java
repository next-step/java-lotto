package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private final String lotto;

    public ManualLottoGenerator(String lotto) {
        this.lotto = lotto;
    }

    @Override
    public Lotto generate() {
        return toLotto(lotto);
    }

    private Lotto toLotto(String lottoNumbers) {
        return new Lotto(parseLottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> parseLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(this::toLottoNumber)
                .collect(Collectors.toList());
    }

    private LottoNumber toLottoNumber(String number) {
        return LottoNumber.getInstance(parseInt(number));
    }

    private int parseInt(String source) {
        return Integer.parseInt(source.trim());
    }
}

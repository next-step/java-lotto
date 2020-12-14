package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    public static final int LOTTO_COUNT = 6;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private List<LottoNumber> lottoNumbers;

    public LottoNumberGenerator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i=START_NUMBER; i<=END_NUMBER; i++) lottoNumbers.add(new LottoNumber(i));
    }

    public Lotto generate() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(
                lottoNumbers.stream()
                        .limit(LOTTO_COUNT)
                        .sorted(Comparator.comparing(LottoNumber::getNumber))
                        .collect(Collectors.toList()));
    }
}

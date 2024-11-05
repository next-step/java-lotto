package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final String DELIMITER = ",";
    private final LottoNumbers lottoNumbers;

    public Lotto(String textNumbers) {
        this(toInts(textNumbers));
    }

    public Lotto(Integer... lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public Lotto(List<Integer> lottoNumbers) {
        this(new LottoNumbers(lottoNumbers));
    }

    // 주생성자
    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumbers.getLottoNumbers();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank determineRank(Lotto lastWinningLotto, int bonusNumber) {
        int matchCount = lottoNumbers.countMatchingNumbers(lastWinningLotto.getLottoNumbers());
        boolean hasBonusNumber = lottoNumbers.contains(new LottoNumber(bonusNumber));
        return LottoRank.findRankByMatchCount(matchCount, hasBonusNumber);
    }

    private static List<Integer> toInts(String textNumbers) {
        String[] strings = textNumbers.split(DELIMITER);
        return Arrays.stream(strings)
                .map(string -> Integer.parseInt(string.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

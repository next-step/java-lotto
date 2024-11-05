package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Lotto {
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String textNumbers) {
        this(toIntegers(textNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(Integer... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (Set.copyOf(lottoNumbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호로 구성되어야 합니다.");
        }
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return unmodifiableList(lottoNumbers);
    }

    public LottoRank determineRank(Lotto lastWinningLotto, int bonusNumber) {
        int matchCount = countMatchingNumbers(lastWinningLotto);
        boolean hasBonusNumber = lottoNumbers.contains(new LottoNumber(bonusNumber));
        return LottoRank.findRankByMatchCount(matchCount, hasBonusNumber);
    }

    private static List<Integer> toIntegers(String textNumbers) {
        String[] strings = textNumbers.split(DELIMITER);
        return Arrays.stream(strings)
                .map(string -> Integer.parseInt(string.trim()))
                .collect(Collectors.toList());
    }

    private int countMatchingNumbers(Lotto otherLotto) {
        return (int) lottoNumbers.stream()
                .filter(otherLotto.lottoNumbers::contains)
                .count();
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

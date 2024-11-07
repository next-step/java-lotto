package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String DELIMITER = ",";

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(String lottoNumbers, int bonusNumber) {
        this(toIntegers(lottoNumbers), bonusNumber);
    }

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this(lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank findRank(Lotto lotto) {
        int matchCount = countMatchingNumbers(lotto);
        boolean hasBonusNumber = hasBonusNumber(lotto);
        return LottoRank.findRankByMatchCount(matchCount, hasBonusNumber);
    }

    private static List<Integer> toIntegers(String textNumbers) {
        String[] strings = textNumbers.split(DELIMITER);
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}

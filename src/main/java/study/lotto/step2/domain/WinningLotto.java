package study.lotto.step2.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String COMMA = ",";
    private static final int NUMBERS_OF_WINNING = 6;
    private final Set<LottoNumber> winningLottoNumbers;

    public WinningLotto(String csvWinningLottoNumbers) {
        this(of(csvWinningLottoNumbers.split(COMMA)));
    }

    public WinningLotto(Integer...winningLottoNumbers) {
        this(of(winningLottoNumbers));
    }

    public WinningLotto(Set<LottoNumber> winningLottoNumbers) {
        validateWinningLottoNumbers(winningLottoNumbers);
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLottoNumbers.contains(lottoNumber);
    }

    public int numbersOfMatch(Lotto lotto) {
        return numbersOfMatch(lotto.getLottoNumbers());
    }

    private int numbersOfMatch(LottoNumbers lottoNumbers) {
        return numbersOfMatch(lottoNumbers.getLottoNumbers());
    }

    private int numbersOfMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .mapToInt(lottoNumber -> 1)
                .sum();
    }

    private void validateWinningLottoNumbers(Set<LottoNumber> winningLottoNumbers) {
        if(winningLottoNumbers.size() != NUMBERS_OF_WINNING) {
            throw new IllegalArgumentException("당첨 번호 갯수는 " + NUMBERS_OF_WINNING + "개입니다: " + winningLottoNumbers.size());
        }
    }

    private static Set<LottoNumber> of(Integer...winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static Set<LottoNumber> of(String[] winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers)
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLottoNumbers, that.winningLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoNumbers);
    }
}

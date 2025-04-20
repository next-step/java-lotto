package step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 당첨 로또 클래스
 */
public class WinningNumber {
    private final LottoNumbers lottoNumbers;
    private final Integer bonusNumber;

    // String을 받아 우승 로또번호를 만든다.
    public WinningNumber(String winningNumbers, int bonusNumber) {
        this.lottoNumbers = LottoNumbers.ofManual(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<Lotto, MatchResult> createMatchResultMap(Lottos bought) {
        return bought.createMatchResultMap(lottoNumbers, bonusNumber);
    }
}

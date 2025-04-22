package step4.domain;

/**
 * 당첨번호 클래스(VO)
 * 행위 : 로또 받아서 몇개 당첨됐는지 알려줌
 */
public class WinningNumber {
    private final LottoNumbers winningNumbers;
    private final Integer bonusNumber;

    // String을 받아 우승 로또번호를 만든다.
    public WinningNumber(String winningNumbers, int bonusNumber) {
        this.winningNumbers = LottoNumbers.ofManual(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    //getter 사용 자제를 위해 역참조
    public MatchResult match(Lotto lotto) {
        return lotto.match(winningNumbers, bonusNumber);
    }
}

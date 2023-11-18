package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 로또 등수 판정 로직들을 묶는 인터페이스입니다.
 */
public interface WinningRule {
    /**
     * 주어진 로또에 주어진 당첨 번호를 대조해 봤을 때 이 등수 판정 로직에 부합한다면 true를 반환합니다.
     * true를 받았다면 getRank()를 이용하여 몇 등인지 확인할 수 있습니다.
     *
     * @param lotto 로또
     * @param winningNumber 당첨 번호
     * @return 판정 여부
     */
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber);
}
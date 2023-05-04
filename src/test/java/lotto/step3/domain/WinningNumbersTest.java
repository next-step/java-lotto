package lotto.step3.domain;

import lotto.step3.enums.MatchNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.step3.domain.Fixture.lottosList;
import static lotto.step3.domain.Fixture.winningNumber;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    @Test
    @DisplayName("기존 5개 번호가 일치하고 나머지 하나의 번호가 보너스 번호와 일치하면 MatchNumber-SECOND 반환")
    void bonusNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        Lottos lottos = new Lottos(lottosList);
        BonusNumber bonusNumber = new BonusNumber(Fixture.bonusNumber, winningNumbers);
        Result result = new Result(winningNumbers.getWinnerStat(lottos, bonusNumber.getBonusNumber()));
        result.getStat().forEach((k, v) -> assertThat(k).isEqualTo(MatchNumber.SECOND));

    }
}
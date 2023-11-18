package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinnerTest {

    @DisplayName("지난주 당첨번호, 로또 번호가 5개가 아니게 겹치고 보너스 볼이 있는 경우 보너스볼으 무시하고 결과를 반환합니다.")
    @Test
    void calculate() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        WinningLottoAndBonusBall winningLottoAndBonusBall = new WinningLottoAndBonusBall(targetLotto, new BonusBall(4));
        // when
        Winner winner = Winner.calculateWinner(myLotto, winningLottoAndBonusBall);
        // then
        Assertions.assertThat(winner).isEqualTo(Winner.FIFTH);
    }

    @DisplayName("지난주 당첨번호, 로또 번호가 5개 겹치고 보너스 볼이 있는 경우 보너스볼까지 맞다면 참고하여 결과를 반환합니다.")
    @Test
    void bonusBall() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLottoAndBonusBall winningLottoAndBonusBall = new WinningLottoAndBonusBall(targetLotto, new BonusBall(6));
        // when
        Winner winner = Winner.calculateWinner(myLotto, winningLottoAndBonusBall);
        // then
        Assertions.assertThat(winner).isEqualTo(Winner.SECOND);
    }

    @DisplayName("지난주 당첨번호, 로또 번호가 5개 겹치고 보너스 볼이 있는 경우 보너스볼은 다르다면 기존 결과를 반환합니다.")
    @Test
    void notMatchBonusBall() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLottoAndBonusBall winningLottoAndBonusBall = new WinningLottoAndBonusBall(targetLotto, new BonusBall(8));
        // when
        Winner winner = Winner.calculateWinner(myLotto, winningLottoAndBonusBall);
        // then
        Assertions.assertThat(winner).isEqualTo(Winner.THIRD);
    }


}
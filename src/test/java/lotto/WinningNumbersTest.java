package lotto;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNo.INVALID_LOTTO_NUMBER_INPUT;
import static lotto.domain.LottoTicket.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.domain.WinningNumbers.BONUS_BALL_CAN_NOT_SAME_AS_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

  @Test
  @DisplayName("당첨 번호 6개와 보너스 번호를 입력하여 생성하고 `WinningNumbers` 를 생성할 수 있으며 같은 번호를 갖는지 검증할 수 있다.")
  void winningNumbersTest() {
    Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;
    Set<LottoNo> expected = Set.of(1, 2, 3, 4, 5, 6).stream().map(LottoNo::of).collect(Collectors.toSet());
    assertThat(WinningNumbers.of(lottoNumbers, bonusNumber).isSame(expected)).isTrue();
  }

  @Test
  @DisplayName("1 ~ 45 내의 숫자가 들어왔는지 벨리데이션")
  void winningNumbersTest2() {
    Set<Integer> given = Set.of(100, 2, 3, 4, 5, 6);
    assertThatThrownBy(() -> LottoTicket.generate(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LOTTO_NUMBER_INPUT, 100));
  }

  @Test
  @DisplayName("6개 숫자가 들어왔는지 벨리데이션")
  void winningNumbersTest3() {
    Set<Integer> given = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    assertThatThrownBy(() -> LottoTicket.generate(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LOTTO_NUMBER_SIZE, given));
  }

  @Test
  @DisplayName("보너스 볼은 당첨 번호와 중복되면 안되므로 숫자 벨리데이션")
  void winningNumbersTest4() {
    Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    int bonusBallNumber = 6;
    assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusBallNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(BONUS_BALL_CAN_NOT_SAME_AS_WINNING_NUMBER);
  }
}

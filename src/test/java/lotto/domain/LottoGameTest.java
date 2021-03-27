package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

  private static LottoBallMachine lottoBallMachine;

  @BeforeAll
  static void setUp() {
    lottoBallMachine = new LottoBallMachine();
    lottoBallMachine.initialize();
  }

  @DisplayName("로또 공 개수가 6개가 아니면 예외 발생")
  @Test
  void lottoBall_no_six_then_exception() {
    assertThatThrownBy(() -> new LottoGame(new LottoBalls(Arrays.asList(new LottoBall(1)))))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 공 개수가 6개가 아닙니다.");
  }

}
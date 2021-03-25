package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

  @Test
  @DisplayName("lotto 구입금액이 올바르지 않을 경우 예외처리 테스트")
  public void check() {
    assertThatThrownBy(() -> {
      // 로또 최소 구매 금액 이하인경우
      Lottos.check(500);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      // 로또 구매후 잔액이 남는 경우
      Lottos.check(1500);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}

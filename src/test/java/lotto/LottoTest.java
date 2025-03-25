package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {

  @DisplayName("로또 생성 시 중복 번호가 없어야 한다.")
  @Test
  void testNoDuplicateNumber() {

    assertThatThrownBy(() -> {
      new Lotto(List.of(
              new LottoNumber(1),
              new LottoNumber(1),
              new LottoNumber(2),
              new LottoNumber(3),
              new LottoNumber(4),
              new LottoNumber(5)
      ));
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("로또 번호는 중복되지 않아야 합니다.");
  }

  @DisplayName("로또 생성 시 번호가 6개가 아니면 예외를 발생한다.")
  @Test
  void testSize() {
    assertThatThrownBy(() -> {
      new Lotto(List.of(
              new LottoNumber(1),
              new LottoNumber(2),
              new LottoNumber(3),
              new LottoNumber(4),
              new LottoNumber(5)
      ));
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("로또 번호는 6개여야 합니다.");
  }
}
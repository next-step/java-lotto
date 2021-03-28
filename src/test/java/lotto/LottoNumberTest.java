package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

  private LottoNumber lottoNumber;

  @BeforeEach
  void setUp() {
    lottoNumber = LottoNumber.of(3);
  }

  @Test
  @DisplayName("[LottoNumber] LottoNumber 생성 테스트")
  void createLottoNumberTest() {
    assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    assertThat(lottoNumber == LottoNumber.of(3)).isTrue();
  }

  @Test
  @DisplayName("[LottoNumber] 로또 번호 범위 검증 테스트")
  void validateRangeTest() {
    int number = 46;

    assertThatThrownBy(() -> LottoNumber.of(number))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

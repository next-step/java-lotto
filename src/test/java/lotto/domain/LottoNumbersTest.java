package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersTest {

  @Test
  @DisplayName("6개의 임의의 로또 숫자를 생성한다.")
  void generateSixNumbers() {
    // given
    LottoNumbers lottoNumbers = LottoNumbers.generateSixNumbers();

    // when
    int actual = lottoNumbers.size();

    // then
    assertThat(actual).isEqualTo(6);
  }

  @Test
  @DisplayName("생성된 로또 번호들에 대해 추가/수정/삭제를 할 수 없다.")
  void generateSixNumbers_immutableList() {
    LottoNumbers lottoNumbers = LottoNumbers.generateSixNumbers();
    List<LottoNumber> list = lottoNumbers.getLottoNumbers();

    assertAll(() -> assertThatThrownBy(() -> list.add(LottoNumber.generate(1))).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThatThrownBy(() -> list.remove(0)).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThatThrownBy(() -> list.replaceAll(lotto -> LottoNumber.generate(1))).isInstanceOf(UnsupportedOperationException.class)
    );
  }
}

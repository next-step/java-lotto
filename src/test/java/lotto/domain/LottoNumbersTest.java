package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumbersTest {
  @DisplayName("로또 번호는 6개여야 한다.")
  @Test
  void testLottoNumbersSize() {

    assertThatThrownBy(() -> {
      new LottoNumbers(List.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5)
      ));
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("로또 번호는 6개여야 합니다.");
  }

  @DisplayName("로또 번호는 중복되지 않아야 한다.")
  @Test
  void testLottoNumbersDuplication() {
    assertThatThrownBy(() -> {
      new LottoNumbers(List.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(5)
      ));
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("로또 번호는 중복되지 않아야 합니다.");
  }

  @DisplayName("로또 번호리스트에 해당 번호가 포함되어있는지 확인한다.")
  @Test
  void testContains() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(4),
      new LottoNumber(5),
      new LottoNumber(6)
    ));

    assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    assertThat(lottoNumbers.contains(new LottoNumber(7))).isFalse();
  }

  @DisplayName("로또 번호리스트와 다른 로또 번호리스트와 일치하는 번호의 개수를 반환한다.")
  @Test
  void testCountMatching() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(4),
      new LottoNumber(5),
      new LottoNumber(6)
    ));

    LottoNumbers other = new LottoNumbers(List.of(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(7),
      new LottoNumber(8),
      new LottoNumber(9)
    ));

    assertThat(lottoNumbers.countMatching(other)).isEqualTo(3);
  }

  @DisplayName("로또 번호리스트를 문자열로 반환한다.")
  @Test
  void testFormat() {
    LottoNumbers lottoNumbers = new LottoNumbers(List.of(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(4),
      new LottoNumber(5),
      new LottoNumber(6)
    ));

    assertThat(lottoNumbers.format()).isEqualTo("1, 2, 3, 4, 5, 6");
  }
}
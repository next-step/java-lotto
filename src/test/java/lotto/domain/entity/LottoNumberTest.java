package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 15, 20, 37, 42, 45})
  @DisplayName("1~45까지의 로또번호가 생성되는지 확인한다.")
  void create(int input) {
    LottoNumber lottoNumber = new LottoNumber(input);
    assertEquals(input, lottoNumber.getNumber());
  }

  @ParameterizedTest
  @ValueSource(ints = {46, 50, 100, 200})
  @DisplayName("45를 초과한 번호를 입력했을때 번호가 생성되지 않고 exception을 던진다.")
  void inValidCreateLottoNumber(int input) {
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(input));
  }

}
package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

  @Test
  void create() {
    LottoNumber lottoNumber = new LottoNumber(30);
    assertEquals(30, lottoNumber.getNumber());
  }

  @ParameterizedTest
  @ValueSource(ints = {46, 50, 100, 200})
  void inValidCreateLottoNumber(int input) {
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(input));
  }

}
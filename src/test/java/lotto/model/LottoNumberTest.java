package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

  @Test
  @DisplayName("로또의 범위에 넘어서는 숫자를 입력하실 수 없습니다.")
  void lottoNotNegativeNumber() {
    assertThrows(RuntimeException.class, () -> {
      new LottoNumber(-1);
      new LottoNumber(46);
    });
  }
}
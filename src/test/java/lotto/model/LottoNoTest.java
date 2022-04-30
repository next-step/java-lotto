package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNoTest {

  @Test
  @DisplayName("로또는 0이하의 숫자를 입력할 수 없습니다.")
  void lottoNotNegativeNumber() {
    assertThrows(RuntimeException.class, () -> {
      new LottoNumber(-1);
    });
  }
}
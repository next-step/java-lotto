package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumsTest {

  @DisplayName("생성자 테스트")
  @Test
  public void constructorTest() {
    assertAll(
        () ->  assertDoesNotThrow(() -> LottoNums.valueOf(List.of(1, 2, 3, 4, 5, 6))),
        () ->  assertThrows(RuntimeException.class, () -> LottoNums.valueOf(List.of(1, 2, 3, 4, 5))),
        () ->  assertThrows(RuntimeException.class, () -> LottoNums.valueOf(List.of(1, 2, 3, 4, 5, 47)))
    );
  }

  @DisplayName("당첨번호 일치 수 가져오기")
  @Test
  public void testGetMatchCount() {
    LottoNums lottoNums = LottoNums.valueOf(List.of(1, 2, 3, 4, 5, 6));
    assertAll(
        () -> assertThat(lottoNums.getMatchCount(WinningNums.valueOf("1, 2, 3, 4, 5, 6")))
            .isEqualTo(6),
        () -> assertThat(lottoNums.getMatchCount(WinningNums.valueOf("7, 8, 9, 10, 11, 12")))
            .isEqualTo(0),
        () -> assertThat(lottoNums.getMatchCount(WinningNums.valueOf("1, 2, 3, 10, 11, 12")))
            .isEqualTo(3),
        () -> assertThrows(RuntimeException.class, () -> lottoNums.getMatchCount(WinningNums.valueOf("7, 8, 9, 10")))
    );
  }
}

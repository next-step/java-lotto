package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumListTest {

  @DisplayName("생성자 테스트")
  @Test
  public void constructorTest() {
    assertDoesNotThrow(() -> LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)));
  }

  @DisplayName("당첨번호 일치 수 가져오기")
  @Test
  public void testGetMatchCount() {
    LottoNumList lottoNumList = LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6));
    assertAll(
        () -> assertThat(lottoNumList.getMatchCount(WinningNums.valueOf("1, 2, 3, 4, 5, 6")))
            .isEqualTo(6),
        () -> assertThat(lottoNumList.getMatchCount(WinningNums.valueOf("7, 8, 9, 10, 11, 12")))
            .isEqualTo(0),
        () -> assertThat(lottoNumList.getMatchCount(WinningNums.valueOf("1, 2, 3, 10, 11, 12")))
            .isEqualTo(3),
        () -> assertThrows(RuntimeException.class, () -> lottoNumList.getMatchCount(WinningNums.valueOf("7, 8, 9, 10")))
    );
  }
}

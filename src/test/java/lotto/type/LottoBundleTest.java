package lotto.type;

import lotto.generator.LottoNumGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    LottoBundle bundle = LottoBundle.valueOf(List.of(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6))));

    assertThat(bundle)
        .isEqualTo(LottoBundle.valueOf(List.of(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)))));
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    LottoBundle bundle = LottoBundle.generate(
        1,
        new LottoNumGenerator(6, 45),
        nums -> nums
    );

    assertThat(bundle)
        .isEqualTo(LottoBundle.valueOf(List.of(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)))));
  }

  @DisplayName("결과 가져오기")
  @Test
  void testGetResults() {
    LottoBundle bundle = LottoBundle.valueOf(
        List.of(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)), LottoNumList.valueOf(List.of(10, 11, 12, 13, 15, 16)))
    );

    assertThat(bundle.getLottoPrizes(WinningNums.valueOf("1, 2, 3, 4, 5, 6", 6))).containsExactly(LottoPrize.SIX_MATCHES, LottoPrize.ZERO_MATCHES);
  }
}

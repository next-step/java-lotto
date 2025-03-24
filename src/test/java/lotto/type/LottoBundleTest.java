package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    LottoBundle bundle = new LottoBundle(List.of(new LottoNumList(List.of(1, 2, 3, 4, 5, 6))));

    assertThat(bundle)
        .isEqualTo(new LottoBundle(List.of(new LottoNumList(List.of(1, 2, 3, 4, 5, 6)))));
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    LottoBundle bundle = new LottoBundle(1, candidates -> candidates);

    assertThat(bundle)
        .isEqualTo(new LottoBundle(List.of(new LottoNumList(List.of(1, 2, 3, 4, 5, 6)))));
  }

  @DisplayName("결과 가져오기")
  @Test
  void testGetResults() {
    List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);

    LottoBundle bundle = new LottoBundle(
        List.of(new LottoNumList(List.of(1, 2, 3, 4, 5, 6)), new LottoNumList(List.of(10, 11, 12, 13, 15, 16)))
    );

    assertThat(bundle.getLottoPrizes(winningNums)).containsExactly(LottoPrize.SIX_MATCHES, LottoPrize.ZERO_MATCHES);
  }
}

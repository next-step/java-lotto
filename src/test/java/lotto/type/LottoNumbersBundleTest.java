package lotto.type;

import lotto.strategy.pick.RandomNumberPickStrategy;
import lotto.strategy.shuffle.ShuffleStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersBundleTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    LottoNumbersBundle bundle = new LottoNumbersBundle(List.of(new LottoNumbers("1, 2, 3, 4, 5, 6")));

    assertThat(bundle).isEqualTo(new LottoNumbersBundle(List.of(new LottoNumbers("1, 2, 3, 4, 5, 6"))));
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    ShuffleStrategy shuffleStrategyStub = lottoNumbers -> lottoNumbers;
    RandomNumberPickStrategy randomNumberPickStrategyStub = new RandomNumberPickStrategy() {
      private final Iterator<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6).iterator();

      @Override
      public int pick(int min, int max) {
        if (!numbers.hasNext()) {
          throw new NoSuchElementException("더 이상 숫자가 없습니다.");
        }
        return numbers.next();
      }
    };

    LottoNumbersBundle bundle = new LottoNumbersBundle(1, randomNumberPickStrategyStub, shuffleStrategyStub);

    assertThat(bundle).isEqualTo(new LottoNumbersBundle(List.of(new LottoNumbers("1, 2, 3, 4, 5, 6"))));
  }

  @DisplayName("로또 결과 가져오기")
  @Test
  void testGetResults() {
    LottoNumbersBundle bundle = new LottoNumbersBundle(
        List.of(new LottoNumbers("1, 2, 3, 4, 5, 6"), new LottoNumbers("10, 11, 12, 13, 14, 15"))
    );

    assertAll(
        () -> assertThat(
            bundle.getLottoPrizes(new LottoNumbers("1, 2, 3, 4, 5, 6"), new LottoNumber(7))
        ).containsExactly(LottoPrize.SIX_MATCHES, LottoPrize.ZERO_MATCHES),
        () -> assertThat(
            bundle.getLottoPrizes(new LottoNumbers("1, 2, 3, 4, 5, 7"), new LottoNumber(6))
        ).containsExactly(LottoPrize.FIVE_WITH_BONUS_MATCHES, LottoPrize.ZERO_MATCHES),
        () -> assertThat(
            bundle.getLottoPrizes(new LottoNumbers("1, 2, 3, 4, 5, 7"), new LottoNumber(8))
        ).containsExactly(LottoPrize.FIVE_MATCHES, LottoPrize.ZERO_MATCHES)
    );
  }
}

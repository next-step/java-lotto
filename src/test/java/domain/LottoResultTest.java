package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

  private LottoResult lottoResult;

  @BeforeEach
  void setUp() {
    Lottos lottos = new Lottos();
    lottos.addLotto(new Lotto(makeLottoNumbers("1,2,3,4,5,6")));
    lottos.addLotto(new Lotto(makeLottoNumbers("2,3,4,5,6,45")));
    lottos.addLotto(new Lotto(makeLottoNumbers("3,4,5,6,44,45")));
    lottos.addLotto(new Lotto(makeLottoNumbers("4,5,6,43,44,45")));
    lottos.addLotto(new Lotto(makeLottoNumbers("5,6,42,43,44,45")));
    lottos.addLotto(new Lotto(makeLottoNumbers("6,41,42,43,44,45")));
    lottos.addLotto(new Lotto(makeLottoNumbers("40,41,42,43,44,45")));

    Lotto winningLotto = new Lotto(makeLottoNumbers("1,2,3,4,5,6"));

    lottoResult = new LottoResult(lottos, winningLotto);
  }

  private List<LottoNumber> makeLottoNumbers(String numbers) {
    return Stream.of(numbers.split(","))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }

  @ParameterizedTest
  @MethodSource("lottoPrizeMethodSource")
  @DisplayName("LottoResult는 LottoPrize별 몇 회 당첨되었는지 알려줄 수 있음을 검증하기 위한 테스트")
  void lottoResultCanReturnEachLottoPrizeMatchCount (LottoPrize inputPrize, int expected) {
    // when
    int matchCount = lottoResult.result(inputPrize);

    // then
    assertThat(matchCount).isEqualTo(expected);
  }

  static Stream<Arguments> lottoPrizeMethodSource() {
    return Stream.of(
            Arguments.of(LottoPrize.FIRST, 1),
            Arguments.of(LottoPrize.SECOND, 1),
            Arguments.of(LottoPrize.THIRD, 1),
            Arguments.of(LottoPrize.FOURTH, 1),
            Arguments.of(LottoPrize.NONE, 3)
    );
  }

}

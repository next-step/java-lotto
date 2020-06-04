package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

  @ParameterizedTest
  @MethodSource("lottoListProvider")
  void getLottoList(List<Lotto> lottoList) {
    Lottos lottos = new Lottos(lottoList);

    assertThat(lottos.getLottoList()).isEqualTo(lottoList);
  }

  static Stream<Arguments> lottoListProvider() {
    return Stream.of(
        arguments(Arrays.asList(
            new LottoNumber(1, false),
            new LottoNumber(2, false),
            new LottoNumber(3, false),
            new LottoNumber(4, false),
            new LottoNumber(5, false),
            new LottoNumber(6, false)
        ))
    );
  }
}
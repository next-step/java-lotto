package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  @ParameterizedTest
  @MethodSource("lottoListProvider")
  void getLottoList(List<LottoNumbers> lottoList) {
    Lotto lotto = new Lotto(lottoList);

    assertThat(lotto.getLottoList()).isEqualTo(lottoList);
  }

  static Stream<Arguments> lottoListProvider() {
    return Stream.of(
        arguments(Arrays.asList(
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        ))
    );
  }
}
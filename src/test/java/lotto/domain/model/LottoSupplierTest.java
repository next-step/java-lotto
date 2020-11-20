package lotto.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSupplierTest {

  @ParameterizedTest
  @MethodSource("provideConstruction")
  void 객체_생성_테스트(List<String[]> manualLottoNumbers, int purchasePrice, int expectAutoLottoGameCount) {
    assertThat(new LottoSupplier(manualLottoNumbers, purchasePrice).autoLottoGameCount())
        .isEqualTo(expectAutoLottoGameCount);
  }

  static Stream<Arguments> provideConstruction() {
    return Stream.of(
        Arguments.of(
            Arrays.asList(
                new String[]{"1", "2", "3", "4", "5", "6"},
                new String[]{"1", "2", "3", "4", "5", "10"}
            ),
            3000,
            1
        ),
        Arguments.of(
            Arrays.asList(
                new String[]{"1", "2", "3", "4", "5", "6"},
                new String[]{"1", "2", "3", "4", "5", "10"},
                new String[]{"1", "2", "3", "4", "5", "11"}
            ),
            3000,
            0
        )
    );
  }
}
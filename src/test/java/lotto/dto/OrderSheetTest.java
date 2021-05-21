package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrderSheetTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @ParameterizedTest
  @ValueSource(longs = {1000L, 2000L, 10_000L, 1_000_000_000_000_000L})
  void constructionTest(long given) {
    assertThat(new OrderSheet(given)).isEqualTo(new OrderSheet(given));
  }


}

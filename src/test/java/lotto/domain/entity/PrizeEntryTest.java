package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PrizeEntryTest {

  @ParameterizedTest
  @NullSource
  @DisplayName("PrizeEntry를 생성할때 null을 파라미터로 주면 exception을 반환한다.")
  void createWithNull(Map<Prize, Integer> map) {
    assertThrows(IllegalArgumentException.class,() -> new PrizeEntry(map));
  }

}
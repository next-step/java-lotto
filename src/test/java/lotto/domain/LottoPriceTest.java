package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPriceTest {

  @Test
  void 로또_가격_생성() {
    LottoPrice price = LottoPrice.from(1000);
    assertThat(price.getPrice()).isEqualTo(1000);
  }

  @ParameterizedTest
  @ValueSource(ints = {999, 0, -1})
  void 최소_가격_미만이면_예외_발생(int invalidPrice) {
    assertThatThrownBy(() -> LottoPrice.from(invalidPrice))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 구매 금액은 %d원 이상이어야 합니다.", LottoPrice.PRICE_PER_LOTTO);
  }

  @ParameterizedTest
  @ValueSource(ints = {1001, 1500, 1999})
  void 가격이_1000원_단위가_아니면_예외_발생(int invalidPrice) {
    assertThatThrownBy(() -> LottoPrice.from(invalidPrice))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 구매 금액은 %d원 단위여야 합니다.", LottoPrice.PRICE_PER_LOTTO);
  }

  @Test
  void 로또_개수_계산() {
    LottoPrice price = LottoPrice.from(5000);
    assertThat(price.calculateLottoCount()).isEqualTo(5);
  }
} 
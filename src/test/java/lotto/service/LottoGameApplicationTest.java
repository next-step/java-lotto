package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameApplicationTest {

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 천원단위구매장수확인(int cost, int count) {

    assertThat(LottoGameApplication.getBuyCount(new LottoMoney(cost))).isEqualTo(count);
  }

  @DisplayName("여러장의 로또생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  void 로또생성(int count) {
    assertThat(LottoGameApplication.createLottos(count)).isNotNull();
  }
}
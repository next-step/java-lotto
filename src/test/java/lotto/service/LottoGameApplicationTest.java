package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.domain.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameApplicationTest {

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 천원단위구매장수확인(int cost, int count)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    LottoGameApplication gameApplication = new LottoGameApplication(new LottoMoney(cost));
    Method getNumberOfLotto = gameApplication.getClass()
        .getDeclaredMethod("getNumberOfLotto");
    getNumberOfLotto.setAccessible(true);

    assertThat(getNumberOfLotto.invoke(gameApplication)).isEqualTo(count);

  }

}
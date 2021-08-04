package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottiesTest {

  @DisplayName("입력 갯수만큼 로또 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void 입력한만큼로또생성(int count) {
    Lotties lotties = new Lotties();
    List<Integer> testLotto = new ArrayList<>();
    testLotto.add(1);
    testLotto.add(2);
    testLotto.add(3);
    testLotto.add(4);
    testLotto.add(5);
    testLotto.add(6);

    try {
      Method createLotties = lotties.getClass()
          .getDeclaredMethod("createLotties", int.class, GenerateLottoNumber.class);
      createLotties.setAccessible(true);

      GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0, 6, testLotto);
      createLotties.invoke(lotties, count, generateLottoNumber);

      assertThat(lotties.getLotties().size()).isEqualTo(count);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
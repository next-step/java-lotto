package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class BuyTest {
  @Test
  @DisplayName("lotto 최소 구매 금액 이하인경우, lotto 구입후 잔액이 남은경우 error")
  public void check() {
    assertThatThrownBy(() -> {
      // 로또 최소 구매 금액 이하인경우
      Buy.lottos(500);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      // 로또 구매후 잔액이 남는 경우
      Buy.lottos(1500);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "15000:15"}, delimiter = ':')
  @DisplayName("구매 금액에 맞춰서 정확한 갯수의 lotto 가 생성확인")
  public void buy(int money, int number) {
    List<Lotto> lottos = Buy.lottos(money).lottos();

    assertThat(lottos.size()).isEqualTo(number);
  }

  @ParameterizedTest
  @MethodSource("passiveLottoTestCase")
  @DisplayName("수동구매시 수동이 포함된 로또가 생성되는지 확인")
  public void passiveLotto(int money, List<Lotto> passiveLottos ) {
    final int LOTTO_PRICE = 1000;

    Lottos lottos = Buy.lottos(money, passiveLottos);

    assertThat(lottos.lottos().size()).isEqualTo(money / LOTTO_PRICE);
    passiveLottos.forEach((lotto) -> {
      assertThat(lottos.lottos()).contains(lotto);
    });
  }

  private static Stream<Arguments> passiveLottoTestCase() {
    return Stream.of(
      Arguments.of(
        2000, 
        Arrays.asList(
          new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
          new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        )
      ),
      Arguments.of(
        3000, 
        Arrays.asList(
          new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
          new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        )
      )
    );
  }

  @Test
  @DisplayName("구입 금액을 초과해서 주문할때 에러")
  public void exceedBuyException() {
    int money = 1000;
    List<Lotto> lottos = Arrays.asList(
      new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
      new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
    );

    assertThatThrownBy(() -> {
      Buy.lottos(money, lottos);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}

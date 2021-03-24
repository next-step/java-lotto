package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

  private LottoMachine lottoMachine = new LottoMachine();

  @Test
  @DisplayName("1~45 숫자 6개로 구성된 로또를 생성한다.")
  void generateAuto() {
    //given //when
    Lotto lotto = lottoMachine.generateAuto();
    //then
    assertAll(
        () -> assertEquals(lotto.getTicket().size(), 6),
        () -> assertTrue(lottoMachine.lottoNumbers.containsAll(lotto.getTicket()))
    );
  }

  @Test
  @DisplayName("지정하는 6개의 숫자로 로또를 생성한다.")
  void generateManual() {
    //given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    //when
    Lotto lotto = lottoMachine.generateManual(numbers);
    //then
    assertAll(
        () -> assertEquals(lotto.getTicket().size(), 6),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(1)),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(2)),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(3)),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(4)),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(5)),
        () -> assertThat(lotto.getTicket()).contains(new LottoNumber(6))
    );
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("입력된 갯수만큼 로또를 생성한다.")
  void generateAutoLottos(int count) {
    //given //when

    Lottos lottos = lottoMachine.generateAuto(count);
    //then
    assertEquals(lottos.size(), count);
  }
}
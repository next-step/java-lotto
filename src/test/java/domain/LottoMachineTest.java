package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

  LottoMachine lottoMachine;

  @BeforeEach
  void setUp() {
    lottoMachine = new LottoMachine();
  }

  @Test
  @DisplayName("로또 한장을 생성한다")
  void createLotto() {
    int lottoNum = lottoMachine.createLotto(1000);
    assertThat(lottoNum).isEqualTo(1);
  }

  @Test
  @DisplayName("로또 여러장을 생성한다")
  void createLottos() {
    lottoMachine.createLotto(4000);
    assertThat(lottoMachine.getAllLottoList().size()).isEqualTo(4);
  }

  @Test
  @DisplayName("로또 결과를 확인한다")
  void getLottoResult() {
    lottoMachine.createLotto(4000);
    String result = lottoMachine.getLottoResult(List.of(1, 2, 3, 4, 5, 6));
    assertThat(result).contains("개 일치");
  }
}

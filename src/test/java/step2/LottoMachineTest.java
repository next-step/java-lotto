package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.LottoMachine.inputAmount;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
  private int buyTicketCount = 0;

  private LottoMachine lottoMachine = new LottoMachine(20000);
  private ArrayList<String> defaultLottoNumberArr = new ArrayList<>();

  @BeforeEach
  void setUp() {
    defaultLottoNumberArr = lottoMachine.generateDefaultLottoNumberArr();
    buyTicketCount = lottoMachine.calculateTicketCount(inputAmount);
  }

  @DisplayName("구매금액을 기준으로 몇장의 로또를 살 수 있는지 확인")
  @Test
  void confirmHowManyBuyLottoPerInputAmount() {
    assertThat(lottoMachine.calculateTicketCount(inputAmount)).isEqualTo(20);
  }

  @DisplayName("로또번호를 섞기 위한 값이 45개가 있는지 확인")
  @Test
  void confirmGenerateLottoNumberArr() {
    assertThat(lottoMachine.generateDefaultLottoNumberArr())
        .hasSize(45);
  }

  @DisplayName("6자리의 로또번호가 생성되는지 확인")
  @Test
  void confirmGeneratedRandomLottoNumberArr() {
    assertThat(
        lottoMachine.generateRandomLottoNumberArr(defaultLottoNumberArr))
        .hasSize(6);
  }

  @DisplayName("구매한 로또 티켓수 만큼 티켓들이 발급되었는지 확인")
  @Test
  void confirmIssuedLottoEqualTicketCount() {
    assertThat(lottoMachine
        .issueLottoNumberArr(buyTicketCount, defaultLottoNumberArr))
        .hasSize(20);
  }

}
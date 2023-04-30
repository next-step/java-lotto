package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @Test
  public void 투자한_금액에_맞게_티켓을_만드는지_검증() {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberGenerator();
    LottoMachine lottoMachine = new LottoMachine(randomNumberStrategy);

    int investMoney = 5000;
    List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets(investMoney);

    assertThat(lottoTickets.size()).isEqualTo(5);
  }

  @Test
  public void 만들어진_티켓목록들이_모두_6개숫자를_가지는지_검증() {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberGenerator();
    LottoMachine lottoMachine = new LottoMachine(randomNumberStrategy);

    int investMoney = 2000;
    List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets(investMoney);

    for (LottoTicket lottoTicket : lottoTickets) {
      assertThat(lottoTicket.numbers().size()).isEqualTo(6);
    }
  }

}
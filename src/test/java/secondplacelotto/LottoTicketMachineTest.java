package secondplacelotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.Lotto;
import secondplacelotto.model.LottoTicketMachine;
import secondplacelotto.model.Lottos;
import secondplacelotto.model.Money;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("금액만큼의 로또를 발권해주는가")
    public void ticketedLotto(){
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lottoList.add(new Lotto());
        }

        Money money = new Money(10000);
        LottoTicketMachine ticketMachine = new LottoTicketMachine(money);
        Lottos lottos = ticketMachine.ticketedLottos();
        Lottos testLottos = new Lottos(lottoList);

        assertTrue(lottos.getLottosCount() == testLottos.getLottosCount());
    }
}

package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Ticket;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualLottoGeneratorTest {

    @Test
    public void 수동_로또_생성_티켓_일치() {
        BasicLotto basicLotto = new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6));

        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator();
        BasicLotto generatedLotto = manualLottoGenerator.generate(new Ticket(1, 2, 3, 4, 5, 6));

        assertThat(basicLotto.getTicket()).isEqualTo(generatedLotto.getTicket());
    }
}

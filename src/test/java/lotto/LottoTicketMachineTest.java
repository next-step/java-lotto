package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("랜덥으로 로또를 발행한다.")
    void lottoIssueRandomTest() {
        var machine = new LottoTicketMachine(new Random());
        var lotto = machine.issueRandom();

        Assertions.assertThat(lotto).isInstanceOf(LottoGame.class);
    }

    @Test
    @DisplayName("수동으로 로또를 발행한다.")
    void lottoIssueManualTest() {
        var machine = new LottoTicketMachine(new Random());
        var pickedNumbers = List.of(1, 2, 3, 4, 5, 6);
        var lotto = machine.issueManual(pickedNumbers);

        Assertions.assertThat(lotto.countMatches(pickedNumbers)).isEqualTo(pickedNumbers.size());
    }
}

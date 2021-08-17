package lotto.domain;

import lotto.domain.generator.AutoLottoTicketGenerator;
import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.generator.ManualLottoTicketGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManualLottoTicketGeneratorTest {
    ManualLottoTicketGenerator manualLottoTicketGenerator;

    @BeforeAll
    void setUp() {
        manualLottoTicketGenerator = ManualLottoTicketGenerator.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또티켓_수동생성기를_이용하여_정수_6개를_입력받으면_6개_로또볼을_가진_로또티켓_객체가_생성된다() {
        LottoTicket lottoTicket = manualLottoTicketGenerator.generate();
        assertThat(lottoTicket.toLottoBallSet().size()).isEqualTo(6);
        assertThat(lottoTicket.toLottoBallSet().toArray()).containsExactly(
            LottoBall.select(1), LottoBall.select(2), LottoBall.select(3),
            LottoBall.select(4), LottoBall.select(5), LottoBall.select(6));
    }
}
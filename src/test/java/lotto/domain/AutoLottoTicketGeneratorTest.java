package lotto.domain;

import lotto.domain.generator.AutoLottoTicketGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutoLottoTicketGeneratorTest {
    AutoLottoTicketGenerator autoLottoTicketGenerator;

    @BeforeAll
    void setUp() {
        autoLottoTicketGenerator = new AutoLottoTicketGenerator();
    }

    @Test
    void 로또티켓_자동생성기를_이용하여_로또티켓을_생성하면_6개의_로또볼을_가진_로또티켓_객체가_생성된다() {
        assertThat(autoLottoTicketGenerator.generate().toLottoBallSet().size()).isEqualTo(6);
        assertThat(autoLottoTicketGenerator.generate()).isInstanceOf(LottoTicket.class);
    }
}

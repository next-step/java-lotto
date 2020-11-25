package lotto;

import lotto.domain.Generator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    private Generator generator;

    @BeforeEach
    public void setUp() {
        generator = Generator.newGenerator();
    }

    @Test
    @DisplayName("6개의 숫자를 가진 로또를 생성한다")
   public void generate_lotto_ticket() {
        LottoTicket lottoTicket = generator.generateLottoTicket();
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수량만큼 로또를 생성한다")
    public void generate_lotto_ticket_list() {
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}

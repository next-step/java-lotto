package lotto.backend.domain;

import lotto.backend.domain.generator.AutoNumberGenerator;
import lotto.backend.domain.generator.CustomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    LottoTickets lottoTickets = new LottoTickets();

    @BeforeEach
    void setUp() {
        lottoTickets.add(List.of(
                LottoTicket.create(new AutoNumberGenerator()),
                LottoTicket.create(new AutoNumberGenerator()),
                LottoTicket.create(new AutoNumberGenerator())));
        lottoTickets.add(List.of(
                LottoTicket.create(new CustomNumberGenerator(List.of(1, 2, 10, 15, 16, 30)))));
    }

    @Test
    @DisplayName("전체 로또 갯수 세기")
    void count_total() {
        assertThat(lottoTickets.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("수동 로또 갯수 세기")
    void count_autoLotto() {
        assertThat(lottoTickets.countOfAutoLotto()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동 또로 갯수 세기")
    void count_customLotto() {
        assertThat(lottoTickets.countOfCustomLotto()).isEqualTo(1);
    }

}

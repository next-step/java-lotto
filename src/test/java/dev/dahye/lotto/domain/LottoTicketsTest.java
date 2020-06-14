package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    @ParameterizedTest(name = "티켓 수 = {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("로또 티켓 생성 시 여러장을 발급할 수 있다.")
    void lotto_tickets_issued(int countOfLotto) {
        LottoTickets lottoTickets = LottoTickets.autoIssued(countOfLotto);
        assertThat(lottoTickets.size()).isEqualTo(countOfLotto);
    }

    @ParameterizedTest(name = "티켓 수 = {0}")
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("로또 티켓 생성 시 티켓의 갯수는 0이상의 양수여야 한다.")
    void validate_lotto_tickets_issued(int countOfLotto) {
        assertThatThrownBy(() -> LottoTickets.autoIssued(countOfLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 티켓 생성 갯수가 유효하지 않습니다.");
    }

    @ParameterizedTest(name = "티켓 = {0}")
    @NullAndEmptySource
    @DisplayName("LottoTickets는 null 이나 빈 값으로는 생성할 수 없다.")
    void validate_lotto_tickets_issued(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> LottoTickets.manualIssued(lottoTickets))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LottoTickets는 null이거나 빈 값으로는 생성할 수 없습니다.");
    }
}
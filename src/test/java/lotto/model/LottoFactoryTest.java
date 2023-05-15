package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LottoFactoryTest {

    @DisplayName("로또번호_자동발급_테스트")
    @Test
    void 로또번호_자동발급_테스트() {
        LottoTicket originalTicket = LottoFactory.createAutoLottoTicket();
        LottoTicket differentTicket = LottoFactory.createAutoLottoTicket();

        assertThat(originalTicket).isNotEqualTo(differentTicket);

    }

    @DisplayName("로또번호_N개_자동발급_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또번호_N개_자동발급_테스트(int count) {
        LottoTickets lottoTickets = LottoFactory.createAutoLottoTickets(count);
        List<LottoTicket> lottoTicketsList = lottoTickets.getLottoTickets();

        boolean hasDuplicates = IntStream.range(0, lottoTicketsList.size() - 1)
                .anyMatch(i -> lottoTicketsList.get(i).equals(lottoTicketsList.get(i + 1)));

        assertThat(hasDuplicates).isFalse();
    }
}

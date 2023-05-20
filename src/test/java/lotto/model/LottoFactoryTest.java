package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LottoFactoryTest {

    public static final int AUTO_TICKET_COUNT = 10;

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

    @DisplayName("로또번호_N개_수동발급_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 로또번호_N개_수동발급_테스트(int n) {
        List<LottoNumber> numberList = new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)));
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            manualLottoTickets.add(new LottoTicket(numberList));
        }
        LottoTickets lottoTickets = LottoFactory.createLottoTickets(AUTO_TICKET_COUNT, manualLottoTickets);
        assertThat(lottoTickets.size() - AUTO_TICKET_COUNT).isEqualTo(n);
    }
}

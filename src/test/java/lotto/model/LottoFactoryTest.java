package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("로또번호_발급_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 로또번호_수동_자동_동시발급_테스트(int n) {
        List<LottoNumber> numberList = new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)));

        List<LottoTicket> manualLottoTickets = IntStream.range(0, n)
                .mapToObj(i -> new LottoTicket(new ArrayList<>(numberList)))
                .collect(Collectors.toList());
        LottoTickets lottoTickets = LottoFactory.createLottoTickets(AUTO_TICKET_COUNT, manualLottoTickets);
        assertThat(lottoTickets.size() - AUTO_TICKET_COUNT).isEqualTo(n);
    }

    @DisplayName("로또번호_발급_테스트 : 구매가능한 티켓을 넘은 경우")
    @Test
    void 수동_자동_동시발급_테스트() {
        int totalCount = 9;
        int manualCount = 10;

        List<LottoNumber> numberList = new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)));

        List<LottoTicket> manualLottoTickets = IntStream.range(0, manualCount)
                .mapToObj(i -> new LottoTicket(new ArrayList<>(numberList)))
                .collect(Collectors.toList());

        int manualLottoTicketsCount = manualLottoTickets.size();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoFactory.createLottoTickets(totalCount - manualLottoTicketsCount, manualLottoTickets))
                .withMessageMatching("구매 가능한 티켓 수를 초과했습니다.");
    }
}

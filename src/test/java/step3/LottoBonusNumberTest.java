package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.lotto.LottoTicket;
import step3.domain.lotto.WinningNumbers;
import step3.domain.lotto.firstcollection.LottoNumber;
import step3.domain.lotto.firstcollection.LottoTickets;
import step3.domain.lotto.firstcollection.WinningResults;
import step3.type.WinningType;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.Constant.ERROR_DUPLICATE_NUMBER;
import static step3.Constant.ERROR_OUT_RANGE_NUMBER;

public class LottoBonusNumberTest {


    @DisplayName("2등 보너스 볼 당첨 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoTicketAndWinningNumbers")
    public void matchBonusNumber(LottoTicket lottoTicket, WinningNumbers winningNumbers, WinningType resultType) {
        WinningType winningStatistics = winningNumbers.getWinningStatistics(lottoTicket);
        assertThat(winningStatistics).isEqualTo(resultType);
    }

    private static Stream<Arguments> provideLottoTicketAndWinningNumbers() {
        return Stream.of(
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 5, 7)),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 7),
                        WinningType.RANK_TWO_BONUS),
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 9, 7)),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 7),
                        WinningType.RANK_THREE),
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 9, 10)),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 8),
                        WinningType.RANK_TWO)
        );
    }

    @DisplayName("2등 보너스 번호 중복 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberDuplicate(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 6), bonusNumber))
                .withMessage(ERROR_DUPLICATE_NUMBER);
    }

    @DisplayName("2등 보너스 번호 범위 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void bonusNumberOutRange(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 6), bonusNumber))
                .withMessage(ERROR_OUT_RANGE_NUMBER);
    }

    @DisplayName("2등 보너스 번호 당첨 수익률 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningTicketAndWinningNumber")
    void bonusWinningTicketRevenue(LottoTicket ticket, WinningNumbers winningNumbers) {
        final int BONUS_REVENUE_PERCENT = 30000;

        LottoTickets lottoTickets = new LottoTickets(Collections.singletonList(ticket));
        double revenueRate = winningNumbers.getRevenueRate(lottoTickets);

        //로또 한장으로 보너스 당첨이 되면 수익율은 30000이다.
        assertThat(revenueRate).isEqualTo(BONUS_REVENUE_PERCENT);
    }

    private static Stream<Arguments> provideWinningTicketAndWinningNumber() {
        return Stream.of(
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 5, 6)), WinningNumbers.of("1,2,3,4,5,7", 6))
        );
    }

    @DisplayName("당첨결과 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningResults")
    void winningResultTest(LottoTickets tickets, WinningNumbers winningNumbers, int resultCount) {
        WinningResults winningResults = WinningResults.of(tickets, winningNumbers);
        Integer count = winningResults.countByWinningType(WinningType.RANK_TWO_BONUS);

        assertThat(count).isEqualTo(resultCount);
    }

    private static Stream<Arguments> provideWinningResults() {
        List<LottoTicket> tickets = new ArrayList<LottoTicket>() {{
            add(new LottoTicket(createHashSet(1, 2, 3, 4, 5, 7)));
            add(new LottoTicket(createHashSet(6, 5, 4, 3, 2, 1)));
            add(new LottoTicket(createHashSet(2, 4, 6, 8, 11, 10)));
            add(new LottoTicket(createHashSet(2, 4, 6, 8, 11, 10)));
        }};

        return Stream.of(
                Arguments.of(new LottoTickets(tickets), WinningNumbers.of("1,2,3,4,5,6", 7), 1),
                Arguments.of(new LottoTickets(tickets), WinningNumbers.of("2,4,6,8,11,22", 10), 2)
        );
    }



    private static Set<LottoNumber> createHashSet(int... args) {
        Set<LottoNumber> set = new HashSet<>();
        for (int arg : args) {
            set.add(new LottoNumber(arg));
        }
        return set;
    }
}

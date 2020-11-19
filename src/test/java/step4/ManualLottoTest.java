package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.lotto.LottoTicket;
import step4.domain.lotto.LottoTicketMachine;
import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.LottoNumber;
import step4.domain.lotto.firstcollection.LottoTickets;
import step4.domain.lotto.firstcollection.WinningResults;
import step4.exception.DuplicateNumberException;
import step4.type.LottoType;
import step4.type.WinningType;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static step4.Constant.*;
import static step4.domain.lotto.firstcollection.WinningResults.DECIMAL_POINT_TWO_FIXED;

public class ManualLottoTest {

    @DisplayName("2등 보너스 볼 당첨 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoTicketAndWinningNumbers")
    public void matchBonusNumber(LottoTicket lottoTicket, WinningNumbers winningNumbers, WinningType resultType) {
        WinningType winningStatistics = lottoTicket.compareWinningNumber(winningNumbers);
        assertThat(winningStatistics).isEqualTo(resultType);
    }

    private static Stream<Arguments> provideLottoTicketAndWinningNumbers() {
        return Stream.of(
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 5, 7), LottoType.AUTO),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 7),
                        WinningType.RANK_TWO_BONUS),
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 9, 7), LottoType.AUTO),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 7),
                        WinningType.RANK_THREE),
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 9, 10), LottoType.AUTO),
                        WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 10), 8),
                        WinningType.RANK_TWO)
        );
    }

    @DisplayName("2등 보너스 번호 중복 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberDuplicate(int bonusNumber) {
        assertThatThrownBy(()-> WinningNumbers.of(createHashSet(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(DuplicateNumberException.class)
                .hasMessage(ERROR_DUPLICATE_NUMBER);
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
        WinningResults results = winningNumbers.getWinningStatistics(lottoTickets);
        double revenueRate = Math.round((results.getWinningAmount() / 1000) * DECIMAL_POINT_TWO_FIXED / DECIMAL_POINT_TWO_FIXED);

        //로또 한장으로 보너스 당첨이 되면 수익율은 30000이다.
        assertThat(revenueRate).isEqualTo(BONUS_REVENUE_PERCENT);
    }

    private static Stream<Arguments> provideWinningTicketAndWinningNumber() {
        return Stream.of(
                Arguments.of(new LottoTicket(createHashSet(1, 2, 3, 4, 5, 6), LottoType.AUTO), WinningNumbers.of("1,2,3,4,5,7", 6))
        );
    }

    private static Set<LottoNumber> createHashSet(int... args) {
        Set<LottoNumber> set = new HashSet<>();
        for (int arg : args) {
            set.add(new LottoNumber(arg));
        }
        return set;
    }


    @DisplayName("수동 로또 구매 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideManualLottoCountAndResultForException")
    void purchaseManualLottoForException(int money, int wantedTicketCount, String errorMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    LottoPurchaseInfoDTO dto = new LottoPurchaseInfoDTO.Builder(money)
                            .manualSize(wantedTicketCount)
                            .inputManualNumbers(Collections.emptyList()).build();

                    LottoTicketMachine.ticketing(dto);
                }).withMessage(errorMessage);
    }

    private static Stream<Arguments> provideManualLottoCountAndResultForException() {
        return Stream.of(
                Arguments.of(2000, -1, ERROR_INVALID_PARAMETER),
                Arguments.of(2000, 3, ERROR_INVALID_PARAMETER)
        );
    }

    @DisplayName("수동 구매 로또 번호 입력 테스트")
    @ParameterizedTest
    @MethodSource("provideManualLottoInfoAndNumbers")
    void writeManualLottoNumber(int money, int wantedTicketCount, List<String> inputNumbers, long autoSize) {
        LottoPurchaseInfoDTO lottoPurchaseInfo = new LottoPurchaseInfoDTO.Builder(money)
                .manualSize(wantedTicketCount)
                .inputManualNumbers(inputNumbers)
                .build();

        LottoTickets tickets = LottoTicketMachine.ticketing(lottoPurchaseInfo);

        assertThat(tickets.countTicketByLottoType(LottoType.AUTO)).isEqualTo(autoSize);
        assertThat(tickets.countTickets()).isEqualTo(LottoTicketMachine.countAllowTicket(money));
    }

    private static Stream<Arguments> provideManualLottoInfoAndNumbers() {
        return Stream.of(
                //5000원을 사용해 2장의 수동 구매를 하면 자동 로또는 3장이다.
                Arguments.of(5000, 2, Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"), 3L),
                //2000원을 사용해 2장의 수동 구매를 하면 자동 로또는 0장이다.
                Arguments.of(2000, 2, Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"), 0L),
                //5000원을 사용해 수동 구매를 하지 않으면 전부 로또 구매를 해 5장이다.
                Arguments.of(5000, 0, Collections.emptyList(), 5)

        );
    }
}

package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.lotto.LottoTicket;
import step2.domain.lotto.LottoTicketMachine;
import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumber;
import step2.strategy.LottoNumberMakeStrategy;
import step2.streategy.TestNumberMakeStrategy;
import step2.type.WinningType;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssueTest {
    private LottoTicketMachine lottoTicketMachine;
    private TestNumberMakeStrategy testLottoNumberMakeStrategy;
    private TestNumberMakeStrategy testWinningNumberMakeStrategy;


    @BeforeEach
    void setup() {
        lottoTicketMachine = new LottoTicketMachine();
        testLottoNumberMakeStrategy = new TestNumberMakeStrategy();
        testWinningNumberMakeStrategy = new TestNumberMakeStrategy();
    }


    @DisplayName("입력한 금액에 맞는 로또 구매 횟수 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "7000:7", "14000:14"}, delimiter = ':')
    void issuanceLotto(int inputPrice, int resultLottoCount) {
        int allowCount = lottoTicketMachine.countAllowTicket(inputPrice);
        assertThat(allowCount).isEqualTo(resultLottoCount);
    }

    @DisplayName("로또티켓 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMarkingNumbers")
    void issuanceLotto(List<Integer> input, String resultValue) {
        testLottoNumberMakeStrategy.setupTestValue(input);
        LottoTicket lottoTicket = new LottoTicket(testLottoNumberMakeStrategy);
        assertThat(lottoTicket.getMarkingNumbers()).isEqualTo(resultValue);
        for (Integer value : input) {
            assertThat(lottoTicket.isMarked(value)).isTrue();
        }

    }

    private static Stream<Arguments> provideLottoMarkingNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), "[6, 5, 4, 3, 2, 1]")
        );
    }

    @DisplayName("로또 머신 티켓 발급 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "7000:7", "14000:14"}, delimiter = ':')
    void ticketing(int money, int resultValue) {
        LottoTickets ticketing = lottoTicketMachine.ticketing(money, new LottoNumberMakeStrategy());
        assertThat(ticketing.countTicket()).isEqualTo(resultValue);
    }

    @DisplayName("당첨번호 비교 메소드")
    @ParameterizedTest
    @MethodSource("provideTicketNumberAndWinningNumber")
    void compareTicketAndWinningNumber(List<Integer> inputTicketNumber, List<Integer> inputWinningNumber, WinningType type) {
        testLottoNumberMakeStrategy.setupTestValue(inputTicketNumber);
        testWinningNumberMakeStrategy.setupTestValue(inputWinningNumber);

        LottoTicket lottoTicket = new LottoTicket(testLottoNumberMakeStrategy);
        WinningNumber winningNumber = WinningNumberGenerator.create(testWinningNumberMakeStrategy);

        WinningType winningType = lottoTicket.compareWinningNumber(winningNumber);

        assertThat(winningType).isEqualTo(type);
    }

    private static Stream<Arguments> provideTicketNumberAndWinningNumber() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 10, 12, 13, 14), WinningType.RANK_ETC),
                Arguments.arguments(Arrays.asList(10, 11, 13, 14, 15, 17), Arrays.asList(11, 13, 17, 41, 42, 43), WinningType.RANK_FOUR),
                Arguments.arguments(Arrays.asList(11, 14, 23, 12, 31, 32), Arrays.asList(31, 12, 23, 14, 10, 44), WinningType.RANK_THREE),
                Arguments.arguments(Arrays.asList(11, 14, 23, 12, 31, 32), Arrays.asList(31, 12, 23, 14, 10, 32), WinningType.RANK_TWO),
                Arguments.arguments(Arrays.asList(11, 14, 23, 12, 31, 32), Arrays.asList(31, 12, 23, 14, 11, 32), WinningType.RANK_ONE)
        );
    }


    @DisplayName("수익률 계산 메소드")
    @ParameterizedTest
    @MethodSource("provideTicketsAndWinningNumber")
    void revenueRate(List<LottoTicket> tickets, List<Integer> winningNumber, double revenueRate) {
        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getRevenueRate(WinningNumber.of(winningNumber))).isEqualTo(revenueRate);
    }

    private static Stream<Arguments> provideTicketsAndWinningNumber() {
        List<LottoTicket> list = new ArrayList<>();
        list.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        list.add(new LottoTicket(Arrays.asList(5, 5, 9, 10, 11, 12)));
        return Stream.of(
                Arguments.of(list, Arrays.asList(3, 4, 6, 17, 19, 20), 0.45)
        );
    }


}

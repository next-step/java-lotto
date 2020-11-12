package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.lotto.*;
import step2.strategy.LottoNumberMakeStrategy;
import step2.streategy.TestNumberMakeStrategy;
import step2.type.WinningType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssueTest {
    private TestNumberMakeStrategy testLottoNumberMakeStrategy;
    private TestNumberMakeStrategy testWinningNumberMakeStrategy;


    @BeforeEach
    void setup() {
        testLottoNumberMakeStrategy = new TestNumberMakeStrategy();
        testWinningNumberMakeStrategy = new TestNumberMakeStrategy();
    }


    @DisplayName("입력한 금액에 맞는 로또 구매 횟수 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "7000:7", "14000:14"}, delimiter = ':')
    void issuanceLotto(int inputPrice, int resultLottoCount) {
        int allowCount = LottoTicketMachine.countAllowTicket(inputPrice);
        assertThat(allowCount).isEqualTo(resultLottoCount);
    }

    @DisplayName("로또티켓 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMarkingNumbers")
    void issuanceLotto(Set<Integer> input, String resultValue) {
        testLottoNumberMakeStrategy.setupTestValue(input.stream().map(LottoNumber::new).collect(Collectors.toSet()));
        LottoTicket lottoTicket = new LottoTicket(testLottoNumberMakeStrategy);
        assertThat(lottoTicket.getMarkingNumbers()).isEqualTo(resultValue);
        for (Integer value : input) {
            assertThat(lottoTicket.isMarked(new LottoNumber(value))).isTrue();
        }

    }

    private static Stream<Arguments> provideLottoMarkingNumbers() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), "[1, 2, 3, 4, 5, 6]")
        );
    }

    @DisplayName("로또 머신 티켓 발급 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "7000:7", "14000:14"}, delimiter = ':')
    void ticketing(int money, int resultValue) {
        LottoTickets ticketing = LottoTicketMachine.ticketing(money, new LottoNumberMakeStrategy());
        assertThat(ticketing.countTicket()).isEqualTo(resultValue);
    }

    @DisplayName("당첨번호 비교 메소드")
    @ParameterizedTest
    @MethodSource("provideTicketNumberAndWinningNumber")
    void compareTicketAndWinningNumber(Set<LottoNumber> inputTicketNumber, Set<LottoNumber> inputWinningNumber, WinningType type) {
        testLottoNumberMakeStrategy.setupTestValue(inputTicketNumber);
        testWinningNumberMakeStrategy.setupTestValue(inputWinningNumber);

        LottoTicket lottoTicket = new LottoTicket(testLottoNumberMakeStrategy);
        WinningNumbers winningNumbers = WinningNumberGenerator.create(testWinningNumberMakeStrategy);

        WinningType winningType = winningNumbers.compareWinningNumber(lottoTicket);

        assertThat(winningType).isEqualTo(type);
    }

    private static Stream<Arguments> provideTicketNumberAndWinningNumber() {
        return Stream.of(
                Arguments.arguments(createHashSet(1, 2, 3, 4, 5, 6), createHashSet(1, 2, 10, 12, 13, 14), WinningType.RANK_ETC),
                Arguments.arguments(createHashSet(10, 11, 13, 14, 15, 17), createHashSet(11, 13, 17, 41, 42, 43), WinningType.RANK_FOUR),
                Arguments.arguments(createHashSet(11, 14, 23, 12, 31, 32), createHashSet(31, 12, 23, 14, 10, 44), WinningType.RANK_THREE),
                Arguments.arguments(createHashSet(11, 14, 23, 12, 31, 32), createHashSet(31, 12, 23, 14, 10, 32), WinningType.RANK_TWO),
                Arguments.arguments(createHashSet(11, 14, 23, 12, 31, 32), createHashSet(31, 12, 23, 14, 11, 32), WinningType.RANK_ONE)
        );
    }
    private static Set<LottoNumber> createHashSet(int... args){
        Set<LottoNumber> set = new HashSet<>();
        for (int arg : args) {
            set.add(new LottoNumber(arg));
        }
        return set;
    }


    @DisplayName("수익률 계산 메소드")
    @ParameterizedTest
    @MethodSource("provideTicketsAndWinningNumber")
    void revenueRate(List<LottoTicket> tickets, WinningNumbers winningNumbers, double revenueRate) {
        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getRevenueRate(winningNumbers)).isEqualTo(revenueRate);
    }

    private static Stream<Arguments> provideTicketsAndWinningNumber() {
        List<LottoTicket> list = new ArrayList<>();
        list.add(createLottoTicket(3, 4, 6, 22, 23, 24));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        list.add(createLottoTicket(5, 5, 9, 10, 11, 12));
        return Stream.of(
                Arguments.of(list, WinningNumbers.of(createHashSet(3, 4, 6, 17, 19, 20)), 0.45)
        );
    }

    private static LottoTicket createLottoTicket(int... args) {
        Set<LottoNumber> set = new HashSet<>();
        for (int arg : args) {
            set.add(new LottoNumber(arg));
        }
        return new LottoTicket(set);
    }


}

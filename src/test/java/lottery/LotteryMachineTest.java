package lottery;

import lottery.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LotteryMachineTest {

    @DisplayName("LotteryMachine 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1300, 5000, 2300, 6000})
    public void makeLotteryMachineObject(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
        int lotteryTicketPrice = 1000;

        assertThat(lotteryMachine.getLotteryTicketCounts())
                .isEqualTo(userInput / lotteryTicketPrice);
    }

    @DisplayName("LotteryMachine 객체 생성 실패 테스트 (로또 티켓 가격보다 구매 금액이 낮은 경우)")
    @ParameterizedTest
    @ValueSource(longs = {999, 980, 300, 500, 1})
    public void throwExceptionOnMakingLotteryMachineObject(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
                });
    }

    @DisplayName("LotteryMachine에서 주어진 금액만큼 LotteryTicket 생성해 LotteryTicketGroups를 get")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4000})
    public void getLotteryTicketGroups(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);

        assertThatCode(() -> {
            LotteryTicketsGroup lotteryTicketsGroup = lotteryMachine.makeLotteryTicketsGroup();
        }).doesNotThrowAnyException();
    }

    @DisplayName("LotteryMachine에서 당첨 번호를 비교해 당첨된 로또 티켓들만 반환")
    @ParameterizedTest
    @MethodSource("mockLotteryTicketBuilder")
    public void findLotteryWinnerTicketsGroup(LotteryTicket winnerTicket, LotteryRanks lotteryRank,
                                              int winnerCounts) {
        LotteryMachine lotteryMachine = new LotteryMachine(new PurchasePrice(1000));
        LotteryTicket loser = new LotteryTicket(Arrays.stream("1,2,3,4,5,6".split(","))
                .map(number -> new LotteryNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));
        LotteryTicket winner = new LotteryTicket(Arrays.stream("11,22,33,44,1,2".split(","))
                .map(number -> new LotteryNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));

        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(Arrays.asList(winner, loser));
        Map<Integer, Integer> winnerTicketsGroup = lotteryMachine
                .findWinnerTicketsMap(lotteryTicketsGroup, winnerTicket);

        assertThat(winnerTicketsGroup.get(lotteryRank.getRequiredNumberCounts())).isEqualTo(winnerCounts);
    }

    private static Stream<Arguments> mockLotteryTicketBuilder() {
        return Stream.of(
                Arguments.of(new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 1, 2")),
                        LotteryRanks.FIRST_PRIZE, 1),
                Arguments.of(new LotteryTicket(StringParser.parseString("1, 2, 3, 44, 9, 8")),
                        LotteryRanks.FOURTH_PRIZE, 2)
        );
    }
}

package lottery;

import lottery.domain.LotteryMachine;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}

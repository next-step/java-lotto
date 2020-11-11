package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryControllerTest {
    @DisplayName("컨트롤러는 객체들과 상호작용 순서가 있다")
    @Test
    void interactionSequence() {
        LotteryController lotteryController = new LotteryController();

        lotteryController.request();

        verifyInteractionSequence("requestMoney->" +
                "responseTicketCount->" +
                "responseTickets->" +
                "requestLastWeekLotteryNumber->" +
                "responseWinningStat->" +
                "responseRateOfReturn");
    }
}

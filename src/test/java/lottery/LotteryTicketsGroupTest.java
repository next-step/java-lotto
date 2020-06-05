package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LotteryTicketsGroupTest {

    private List<LotteryTicket> lotteryTicketList;

    @BeforeEach
    public void setupLotteryTicket() {
        List<LotteryNumber> lotteryNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotteryNumberList.add(LotteryNumber.from(i));
        }
        LotteryTicket lotteryTicket = LotteryTicket.from(lotteryNumberList);
        lotteryTicketList = Arrays.asList(lotteryTicket, lotteryTicket);
    }

    @DisplayName("LotteryTicketsGroup 정상 생성 테스트")
    @Test
    public void makeLotteryTicketsGroupObject() {
        assertThatCode(() -> {
            LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup.from(lotteryTicketList);
            LotteryTicketsGroup automaticLotteryTicketsGroup = LotteryTicketsGroup
                    .publishAutomaticLotteryTicketsGroup(PurchasePrice.of(2000, 0));
        }).doesNotThrowAnyException();

        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup.from(lotteryTicketList);
        LotteryTicketsGroup automaticLotteryTicketsGroup = LotteryTicketsGroup
                .publishAutomaticLotteryTicketsGroup(PurchasePrice.of(2000, 0));

        assertThat(lotteryTicketsGroup.getClass())
                .isEqualTo(LotteryTicketsGroup.class);
        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(automaticLotteryTicketsGroup.getLotteryTicketsNumbers().size());
    }

    @DisplayName("LotteryTicket 들의 번호 리스트를 추출해오는 테스트")
    @Test
    public void getLotteryTicketsNumbers() {
        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup.from(lotteryTicketList);

        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
        List<Integer> oneToSixList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> targetList = Arrays.asList(oneToSixList, oneToSixList);

        assertThat(lotteryTicketsNumbers).isEqualTo(targetList);
    }
}

package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("PurchasePrice와 수동 입력 티켓 번호들을 입력 받으면 정상적으로 티켓 리스트를 반환함")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4444, 5555})
    public void getLotteryTicketsUsingAutoAndManual(long inputPrice) {
        PurchasePrice purchasePrice = PurchasePrice.of(inputPrice, 0);
        List<String[]> manualTicketsNumbers = Arrays.asList("1,2,3,4,5,6".split(","),
                "11,12,13,14,15,16".split(","));

        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup
                .publishLotteryTicketsGroup(purchasePrice, manualTicketsNumbers);

        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(purchasePrice.getAutomaticTicketCounts() + 2);
    }

    @DisplayName("자동이 0개인 경우 티켓 정상 생성")
    @Test
    public void getOnlyAutomaticLotteryTicketsGroup() {
        PurchasePrice purchasePrice = PurchasePrice.of(2000, 2);

        assertThat(purchasePrice.getAutomaticTicketCounts())
                .isEqualTo(0);

        List<String[]> manualTicketsNumbers = Arrays.asList("1,2,3,4,5,6".split(","),
                "11,12,13,14,15,16".split(","));

        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup
                .publishLotteryTicketsGroup(purchasePrice, manualTicketsNumbers);

        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(purchasePrice.getManualTicketCounts());
    }

    @DisplayName("수동이 0개인 경우 티켓 정상 생성")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4000})
    public void getOnlyManualTicketsGroup(long userInput) {
        PurchasePrice purchasePrice = PurchasePrice.of(userInput, 0);

        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup
                .publishLotteryTicketsGroup(purchasePrice, null);

        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(purchasePrice.getAutomaticTicketCounts());
    }
}

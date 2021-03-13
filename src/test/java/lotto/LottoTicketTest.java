package lotto;

import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicket;
import lotto.domain.WinningLotteryTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("자동생성시 중복되는 로또번호가 있는지 갯수는 6개가 맞는지 테스트")
    void create_auto() {
        int price = 1000;
        LotteryTicket lotteryTicket = LotteryTicket.auto(price);
        List<Integer> lottoNumberList = lotteryTicket.getLottoNumberList();
        HashSet<Integer> duplicateRemovedNumberList = new HashSet<>(lottoNumberList);

        assertThat(duplicateRemovedNumberList.size()).isEqualTo(6);
        assertThat(lotteryTicket.getPrice()).isEqualTo(price);
        assertThat(lotteryTicket.getLotteryPrize()).isEqualTo(LotteryPrize.UNDEFINED);
    }

    @Test
    @DisplayName("수동생성 테스트")
    void create_with_selected_numbers() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryTicket lotteryTicket = new LotteryTicket(numberList, price);

        assertThat(lotteryTicket.getPrice()).isEqualTo(price);
        assertThat(lotteryTicket.getLottoNumberList()).isEqualTo(numberList);
        assertThat(lotteryTicket.getLotteryPrize()).isEqualTo(LotteryPrize.UNDEFINED);
    }

    @Test
    @DisplayName("2등 로또를 정확하게 찾는지 테스트")
    void matchSecondLotteryPrize() {
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 100);
        WinningLotteryTicket winningLotteryTicket = new WinningLotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        lotteryTicket.setLotteryPrize(winningLotteryTicket);

        assertThat(lotteryTicket.getLotteryPrize())
                .isEqualTo(LotteryPrize.SECOND);

    }

    @Test
    @DisplayName("3등 로또를 정확하게 찾는지 테스트")
    void matchThirdLotteryPrize() {
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 100);
        WinningLotteryTicket winningLotteryTicket = new WinningLotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 7), 9);

        lotteryTicket.setLotteryPrize(winningLotteryTicket);

        assertThat(lotteryTicket.getLotteryPrize())
                .isEqualTo(LotteryPrize.THIRD);
    }

    @Test
    @DisplayName("4등 로또를 보너스 번호와 관계없이 정확하게 찾는지 테스트")
    void matchFourthLotteryPrize() {
        LotteryTicket lotteryTicketWithMatchingBonusNumber = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 12, 9), 100);
        LotteryTicket lotteryTicketWithOutMatchingBonusNumber = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 12, 22), 100);
        WinningLotteryTicket winningLotteryTicket = new WinningLotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 7), 9);

        lotteryTicketWithMatchingBonusNumber.setLotteryPrize(winningLotteryTicket);
        lotteryTicketWithOutMatchingBonusNumber.setLotteryPrize(winningLotteryTicket);

        assertThat(lotteryTicketWithMatchingBonusNumber.getLotteryPrize())
                .isEqualTo(LotteryPrize.FOURTH);
        assertThat(lotteryTicketWithOutMatchingBonusNumber.getLotteryPrize())
                .isEqualTo(LotteryPrize.FOURTH);
    }

    @Test
    @DisplayName("꽝 로또를 보너스 번호와 관계없이 정확하게 찾는지 테스트")
    void matchNonLotteryPrize() {
        LotteryTicket lotteryTicketWithMatchingBonusNumberOnly = new LotteryTicket(Arrays.asList(10, 11, 12, 13, 14, 9), 100);
        LotteryTicket lotteryTicketWithMatchingTwoNumberWithoutBonusNumber = new LotteryTicket(Arrays.asList(1, 2, 12, 13, 14, 15), 100);
        LotteryTicket lotteryTicketWithMatchingTwoNumberWithBonusNumber = new LotteryTicket(Arrays.asList(1, 2, 12, 13, 14, 9), 100);
        WinningLotteryTicket winningLotteryTicket = new WinningLotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 7), 9);

        lotteryTicketWithMatchingBonusNumberOnly.setLotteryPrize(winningLotteryTicket);
        lotteryTicketWithMatchingTwoNumberWithoutBonusNumber.setLotteryPrize(winningLotteryTicket);
        lotteryTicketWithMatchingTwoNumberWithBonusNumber.setLotteryPrize(winningLotteryTicket);

        assertThat(lotteryTicketWithMatchingBonusNumberOnly.getLotteryPrize())
                .isEqualTo(LotteryPrize.NONE);
        assertThat(lotteryTicketWithMatchingTwoNumberWithoutBonusNumber.getLotteryPrize())
                .isEqualTo(LotteryPrize.NONE);
        assertThat(lotteryTicketWithMatchingTwoNumberWithBonusNumber.getLotteryPrize())
                .isEqualTo(LotteryPrize.NONE);
    }

}

package lotto;

import lotto.domain.LotteryTicket;
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
    }

    @Test
    @DisplayName("수동생성 테스트")
    void create_with_selected_numbers() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryTicket lotteryTicket = new LotteryTicket(numberList, price);

        assertThat(lotteryTicket.getPrice()).isEqualTo(price);
        assertThat(lotteryTicket.getLottoNumberList()).isEqualTo(numberList);
    }



}

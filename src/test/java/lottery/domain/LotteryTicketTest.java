package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTicketTest {
    private static List<LotteryNumber> createLotteryNumbers(List<Integer> ints) {
        return ints.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("로또 티켓을 생성")
    void create() {
        // given
        List<LotteryNumber> lotteryNumbers = createLotteryNumbers(List.of(1, 2, 3, 4, 5, 6));
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryNumbers);

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 티켓이 로또 번호를 6개 가지고 있는지 확인")
    void checkSize() {
        // given
        List<LotteryNumber> lotteryNumbers = createLotteryNumbers(List.of(1, 2, 3, 4, 5, 6, 7));

        // then
        assertThatThrownBy(() -> new LotteryTicket(lotteryNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 티켓은 6개의 로또 번호를 가지고 있어야 합니다.");
    }
}
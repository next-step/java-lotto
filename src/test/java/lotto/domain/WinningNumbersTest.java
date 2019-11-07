package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by kohyusik on 05/11/2019.
 */
class WinningNumbersTest {

    @DisplayName("당첨여부 계산")
    @Test
    void generate() {

        // given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LotteryTicket> tickets = new ArrayList<>();
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6))); // first
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 7))); // second
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 45))); // third
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 44, 45))); // fourth
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 43, 44, 45))); // fifth
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 42, 43, 44, 45))); // miss

        // when
        Map<WinningRanking, Long> countingMap = winningNumbers.getWinningTickets(tickets);
        System.out.println(countingMap);

        // then
        assertThat(countingMap).hasSize(5);

    }

    @DisplayName("유효성 검사 실패: 범위")
    @Test
    void outOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("당첨 번호의 범위는 \\[\\d+, \\d+\\] 입니다.");
    }

    @DisplayName("유효성 검사 실패: 사이즈")
    @Test
    void sizeOver() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("당첨 번호는 [0-9]+개 입니다.");
    }

    @DisplayName("유효성 검사 실패: 숫자 중복")
    @Test
    void duplicate() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("유효성 검사 실패: 보너스 범위")
    @Test
    void bonusRange() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("유효성 검사 실패: 보너스 중복")
    @Test
    void bonusDuplicate() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("보너스")
                .hasMessageContaining("중복");
    }
}

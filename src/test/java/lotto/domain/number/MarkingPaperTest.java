package lotto.domain.number;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.exception.NullLottoBallsListException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MarkingPaperTest {

    @Test
    @DisplayName("로또마킹지에 로또 번호들 마킹하기")
    void mark_lotto_balls() {
        MarkingPaper markingPaper = new MarkingPaper();
        markingPaper.markLottoBalls(numbersToBalls(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(markingPaper.getMarkingSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또번호 리스트가 null 인데 마킹하면 예외 발생")
    void fail_to_mark_lotto_balls_by_null_lotto_balls() {
        MarkingPaper markingPaper = new MarkingPaper();
        assertThatExceptionOfType(NullLottoBallsListException.class)
                .isThrownBy(() -> markingPaper.markLottoBalls(null));
    }

    @Test
    @DisplayName("마킹지를 로또티켓으로 변환하기")
    void convert_papers_to_tickets() {
        List<Integer> inputNumbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> inputNumbers2 = List.of(3, 5, 12, 14, 15, 17);
        MarkingPaper markingPaper = new MarkingPaper();
        markingPaper.markLottoBalls(numbersToBalls(inputNumbers1));
        markingPaper.markLottoBalls(numbersToBalls(inputNumbers2));

        List<Ticket> tickets = markingPaper.convertPapersToTickets();
        assertAll(
                () -> assertThat(tickets).hasSize(2),
                () -> assertThat(getMatchCount(tickets.get(0), inputNumbers1))
                        .isEqualTo(LottoBalls.getBallsSize()),
                () -> assertThat(getMatchCount(tickets.get(1), inputNumbers2))
                        .isEqualTo(LottoBalls.getBallsSize())
        );
    }

    private long getMatchCount(Ticket ticket, List<Integer> numbers) {
        return ticket.getLottoBalls()
                .getBalls()
                .stream()
                .filter(lottoBall -> numbers.contains(lottoBall.getNumber()))
                .count();
    }

}
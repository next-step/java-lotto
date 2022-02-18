package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @DisplayName("입력받은 지난 주 당첨 넘버가 주어졌을 때, 개수 부족시 예외를 발생한다.")
    @Test
    void testAnswerListSizeValid() {
        assertThatThrownBy(() -> new Answer(getTicket(1, 2, 3, 4, 5), new Number(7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 지난 주 당첨 넘버와 보너스가 주어졌을 때, 당첨 넘버와 중복되지 않아야한다.")
    @Test
    void testAnswerBonusNotDuplicated() {
        assertThatThrownBy(() -> new Answer(getTicket(1, 2, 3, 4, 5), new Number(5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 로또 넘버와 지난 주 당첨 넘버가 주어졌을 때, 비교 결과로 예상했던 4등을 반환하여야 한다.")
    @Test
    void testComparisonValid() {
        Answer answer = new Answer(getTicket(8, 21, 23, 41, 42, 43), new Number(7));

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(getTicket(8, 21, 25, 40, 42, 43));

        Map<Rank, Integer> resultMap = answer.getComparisonPrizeMap(new Tickets(tickets));

        assertThat(resultMap)
            .containsEntry(Rank.FOURTH, 1);
    }

    private Ticket getTicket(Integer ...values) {
        return new Ticket(
            Stream.of(values)
                .map(Number::new)
                .collect(Collectors.toList())
        );
    }

}

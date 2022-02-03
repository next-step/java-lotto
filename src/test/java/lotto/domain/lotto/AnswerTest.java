package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerTest {

    private static final List<Integer> BASE_NUMBER_LIST = Arrays.asList(8, 21, 23, 41, 42, 43);
    private static final List<Integer> TEST_NUMBER_LIST = Arrays.asList(8, 21, 25, 40, 42, 43);
    private static final Rank RANK = Rank.FOURTH;
    private static final int MATCHES = 1;
    private static final int BONUS_NUMBER = 8;

    @DisplayName("입력받은 숫자 개수가 유효한지 검증")
    @Test
    void testValidateAnswer() {
        assertDoesNotThrow(() -> new Answer(new Numbers(BASE_NUMBER_LIST), BONUS_NUMBER));
    }

    @DisplayName("일치 여부 유효성 검증")
    @Test
    void testComparisonValid() {
        Answer answer = new Answer(new Numbers(BASE_NUMBER_LIST), BONUS_NUMBER);
        Map<Rank, Integer> resultMap = answer.compare(getTickets());
        assertThat(resultMap.get(RANK))
            .isEqualTo(MATCHES);
    }

    Tickets getTickets() {
        Tickets tickets = new Tickets();
        tickets.addTicket(new Ticket(new Numbers(TEST_NUMBER_LIST)));
        return tickets;
    }
}

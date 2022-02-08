package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    private static final List<Integer> BASE_NUMBER_LIST = Arrays.asList(8, 21, 23, 41, 42, 43);
    private static final List<Integer> TEST_NUMBER_LIST = Arrays.asList(8, 21, 25, 40, 42, 43);
    private static final Rank RANK = Rank.FOURTH;
    private static final int MATCHES = 1;
    private static final int BONUS_NUMBER = 8;

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers(BASE_NUMBER_LIST);
    }

    Tickets getTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(new Numbers(TEST_NUMBER_LIST)));
        return new Tickets(tickets);
    }

    @DisplayName("입력받은 숫자 개수가 유효한지 검증")
    @Test
    void testValidateAnswer() {
        assertDoesNotThrow(() -> new Answer(numbers, BONUS_NUMBER));
    }

    @DisplayName("일치 여부 유효성 검증")
    @Test
    void testComparisonValid() {
        Answer answer = new Answer(numbers, BONUS_NUMBER);
        Map<Rank, Integer> resultMap = answer.compare(getTickets());

        assertThat(resultMap).containsEntry(RANK, MATCHES);
    }
}

package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    private static final List<Integer> BASE_NUMBER_LIST = Arrays.asList(8, 21, 23, 41, 42, 43);
    private static final List<Integer> TEST_NUMBER_LIST = Arrays.asList(8, 21, 25, 40, 42, 43);
    private static final Rank RANK = Rank.FOURTH;
    private static final int MATCHES = 1;
    private static final int BONUS_NUMBER = 11;

    private Numbers numbers;
    private List<Number> testNumberList;

    @BeforeEach
    void setUp() {
        List<Number> baseNumberList = BASE_NUMBER_LIST.stream()
            .map(Number::new)
            .collect(Collectors.toList());
        numbers = new Numbers(baseNumberList);

        testNumberList = TEST_NUMBER_LIST.stream()
            .map(Number::new)
            .collect(Collectors.toList());
    }

    Tickets getTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(new Numbers(testNumberList)));
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

    @DisplayName("당첨번호와 보너스 번호는 중복되면 안된다.")
    @Test
    void testBaseNumberListHasBonusNumber() {
        assertThatThrownBy(() -> new Answer(numbers,8))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

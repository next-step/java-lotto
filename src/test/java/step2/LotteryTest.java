package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottery;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    static List<Number> numbers;

    @BeforeAll
    static void before() {
        numbers = new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
        }};
    }

    @Test
    @DisplayName("Lottery 객체 생성")
    void createFromList() {
        assertThat(Lottery.createFromList(numbers))
                .isEqualTo(Lottery.createFromList(numbers));
    }

    @Test
    @DisplayName("로또 당첨 번호와 사용자가 입력한 로또 번호를 비교하여 몇개가 맞는지 테스트")
    void correctCount() {
        Lottery correctNumbers = Lottery.createFromList(numbers);
        assertThat(Lottery.createFromList(numbers).getCorrectCount(correctNumbers)).isEqualTo(3);
    }

    @Test
    @DisplayName("getList test")
    void getList() {
        assertThat(Lottery.createFromList(numbers).getList()).contains(
                Number.createFromInt(1),
                Number.createFromInt(2),
                Number.createFromInt(3)
        );
    }
}

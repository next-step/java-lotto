package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottery;
import step2.domain.Number;
import step2.domain.util.exception.LotteryFormatException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {
    static List<Number> numbers;

    @BeforeAll
    static void before() {
        numbers = new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
            add(Number.createFromInt(5));
            add(Number.createFromInt(6));
        }};
    }

    @Test
    @DisplayName("Lottery 객체 생성")
    void createFromList() {
        List<Number> exceptionNumbers = new ArrayList() {{
                add(Number.createFromInt(1));
                add(Number.createFromInt(2));
            }};

        assertThatThrownBy(() -> Lottery.createFromList(exceptionNumbers))
                .isInstanceOf(LotteryFormatException.class)
                .hasMessage("복권 번호는 6자리 필수");

        assertThat(Lottery.createFromList(numbers))
                .isEqualTo(Lottery.createFromList(numbers));
    }

    @Test
    @DisplayName("로또 당첨 번호와 사용자가 입력한 로또 번호를 비교하여 몇개가 맞는지 테스트")
    void correctCount() {
        Lottery correctNumbers = Lottery.createFromList(numbers);
        assertThat(Lottery.createFromList(numbers).getCorrectCount(correctNumbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("getList test")
    void getList() {
        assertThat(Lottery.createFromList(numbers).getNumbers()).contains(
                Number.createFromInt(1),
                Number.createFromInt(2),
                Number.createFromInt(3)
        );
    }
}

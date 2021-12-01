package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottery;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    @DisplayName("Lottery 객체 생성")
    void create() {
        List<Number> numbers = new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
        }};

        assertThat(new Lottery(numbers)).isEqualTo(new Lottery(numbers));
    }

    @Test
    @DisplayName("로또 당첨 번호와 사용자가 입력한 로또 번호를 비교하여 몇개가 맞는지 테스트")
    void correctCount() {
        Lottery correctNumbers = new Lottery(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
        }});

        assertThat(new Lottery(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
        }}).correctCount(correctNumbers)).isEqualTo(3);
    }
}

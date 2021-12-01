package step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottery;
import step2.domain.Lotteries;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
    @Test
    @DisplayName("Lotteries 객체 생성")
    void create() {
        List<Number> numbers = new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
        }};

        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(new Lottery(numbers));
        }});

        assertThat(lotteries).isEqualTo(
                new Lotteries(new ArrayList() {{
                    add(new Lottery(numbers));
                }}));
    }

    @Test
    @DisplayName("통계 결과 추출")
    void getStaticResult() {
        Lottery winningLottey = new Lottery(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(4));
        }});

        Lottery lottery1 = new Lottery(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(4));
        }});

        Lottery lottery2 = new Lottery(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(5));
        }});

        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery1);
            add(lottery2);
        }});

        assertThat(lotteries.getStaticResult(winningLottey))
                .containsEntry(3, 1)
                .containsEntry(4, 1)
                .containsEntry(5, 0)
                .containsEntry(6, 0);
    }
}

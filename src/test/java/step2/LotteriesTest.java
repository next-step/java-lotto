package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lottery;
import step2.domain.Lotteries;
import step2.domain.Number;
import step2.domain.enums.RANKING;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
    static Lottery lottery;
    static Lotteries lotteries;

    @BeforeAll
    static void before() {
        lottery = new Lottery(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
        }});

        lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
        }});
    }

    @Test
    @DisplayName("Lotteries 객체 생성")
    void create() {
        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
        }});

        assertThat(lotteries).isEqualTo(
                new Lotteries(new ArrayList() {{
                    add(lottery);
                }}));
    }

    @Test
    @DisplayName("통계 결과 추출")
    void getStaticResult() {
        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
            add(new Lottery(new ArrayList() {{
                add(Number.createFromInt(1));
                add(Number.createFromInt(2));
                add(Number.createFromInt(3));
                add(Number.createFromInt(5));
            }}));
        }});

        assertThat(lotteries.getStaticResult(lottery))
                .containsEntry(RANKING.FOURTH, 1)
                .containsEntry(RANKING.THIRD, 1)
                .containsEntry(RANKING.SECOND, 0)
                .containsEntry(RANKING.FIRST, 0);
    }

    @Test
    @DisplayName("getList test")
    void getList() {
        assertThat(lotteries.getList())
                .contains(lottery);
    }
}

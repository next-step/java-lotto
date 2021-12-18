package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.Number;
import step2.domain.Ranks;
import step2.domain.enums.Rank;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {
    static Lottery lottery;
    static Lotteries lotteries;

    @BeforeAll
    static void before() {
        lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
            add(Number.createFromInt(5));
            add(Number.createFromInt(6));
        }});

        lotteries = Lotteries.createFromList(new ArrayList() {{
            add(lottery);
        }});
    }

    @Test
    @DisplayName("Ranks list 상금 계산")
    void calculateProfitAmount() {
        assertThat(new Ranks(lotteries, lottery).calculateProfitAmount())
                .isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("당첨 등수에 해당되는 상금 get test")
    void getCountOfRank() {
        assertThat(new Ranks(lotteries, lottery).getCountOfRank(Rank.FIRST))
                .isEqualTo(1);
    }
}

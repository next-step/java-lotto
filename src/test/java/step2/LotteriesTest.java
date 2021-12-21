package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lottery;
import step2.domain.Lotteries;
import step2.domain.Number;
import step2.strategy.AutoLotteryStrategy;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
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
    @DisplayName("Lotteries 객체 생성")
    void createFromCount() {
        Lotteries lotteries = Lotteries.createFromCount(new AutoLotteryStrategy(), 1);
        lotteries.getLotteries().forEach(lottery -> {
            lottery.getNumbers().forEach(number -> {
                assertThat(number.getNumber())
                        .isGreaterThan(0)
                        .isLessThanOrEqualTo(45);

            });
        });
    }

    @Test
    @DisplayName("Lotteries 객체 생성")
    void createFromList() {
        assertThat(lotteries).isEqualTo(
                Lotteries.createFromList(new ArrayList() {{
                    add(lottery);
                }}));
    }
    
    @Test
    @DisplayName("getList test")
    void getList() {
        assertThat(lotteries.getLotteries())
                .contains(lottery);
    }
}

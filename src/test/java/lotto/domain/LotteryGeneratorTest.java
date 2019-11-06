package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryGeneratorTest {

    private LotteryGenerator lotteryGenerator;

    @BeforeEach
    void setUp() {
        // given
        lotteryGenerator = new LotteryGenerator(new NumberGenerator());
    }

    @DisplayName("복권 생성기: 단일 생성")
    @Test
    void generateTicket() {

        // when
        LotteryTicket lotteryTickets = lotteryGenerator.generate();

        // then
        assertThat(lotteryTickets).isNotNull();
    }

    @DisplayName("복권 생성기: 여러개 생성")
    @Test
    void generateTickets() {

        // given
        int amount = 14_000;
        int expected = amount / 1_000;

        // when
        List<LotteryTicket> lotteryTickets = lotteryGenerator.generate(amount);

        // then
        assertThat(lotteryTickets).hasSize(expected);
    }
}

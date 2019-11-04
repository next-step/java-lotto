package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryGeneratorTest {

    @DisplayName("복권 생성")
    @Test
    void generateTicket() {

        // given
        LotteryGenerator lotteryGenerator = new LotteryGenerator();

        // when
        LotteryTicket lotteryTickets = lotteryGenerator.generate();

        // then
        assertThat(lotteryTickets).isNotNull();
    }

    @DisplayName("복권 여러개 생성")
    @Test
    void generateTickets() {

        // given
        int expected = 14;
        LotteryGenerator lotteryGenerator = new LotteryGenerator();

        // when
        List<LotteryTicket> lotteryTickets = lotteryGenerator.generate(expected);

        // then
        assertThat(lotteryTickets).hasSize(expected);
    }
}

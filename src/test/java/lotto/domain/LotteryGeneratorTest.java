package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        lotteryGenerator = new LotteryGenerator();
    }

    @DisplayName("복권 생성기: 자동 번호 생성")
    @Test
    void generateTicket() {

        // when
        List<LotteryNumber> numbers = lotteryGenerator.generateAutoNumbers(6);

        // then
        assertThat(numbers).isNotNull();
    }

    @DisplayName("복권 생성기: 여러개 생성")
    @Test
    void generateTickets() {

        // given
        int amount = 14_000;
        int expected = amount / 1_000;
        List<List<Integer>> manualLotteries = new ArrayList<>();

        // when
        List<LotteryTicket> lotteryTickets = lotteryGenerator.generate(amount, manualLotteries);

        // then
        assertThat(lotteryTickets).hasSize(expected);
    }
}

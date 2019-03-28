package lottery.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class RandomGenetatorTest {

    private LotteryMachine lotteryMachine = new LotteryMachine();

    @Test
    public void 자동생성() {
        List<Lottery> result = new RandomGenetator(new Money(1000, 0)).generate();
        assertThat(result.size()).isEqualTo(1);
    }
}
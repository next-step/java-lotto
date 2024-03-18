package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryAwardSystemTest {

    private static final List<Lotto> testLottos = new ArrayList<>();
    private static final Lotto winnerNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < 4; i++) {
            List<Integer> numbers = Arrays.asList(1 + i, 2 + i, 3 + i, 4 + i, 5 + i, 6 + i);
            testLottos.add(new Lotto(numbers));
        }
    }

    @Test
    public void 일등부터_사등까지_정보를_반환한다() {
        LotteryAwardSystem lottoSystem = new LotteryAwardSystem(testLottos, winnerNumbers, 4000);
        Map<Integer, Integer> winnersCountMap = lottoSystem.getWinnersCountMap();

        assertAll(
                () -> assertThat(winnersCountMap.get(6)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(5)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(4)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(3)).isEqualTo(1)
        );
    }

    @Test
    public void 수익률을_알려준다() {
        LotteryAwardSystem lottoSystem = new LotteryAwardSystem(testLottos, winnerNumbers, 4000);

        assertThat(lottoSystem.getProfitRate()).isEqualTo(500388.75);
    }
}

package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void create() {
        List<Lotto> lottoList = LottoMachine.getInstance().create(10);
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test
    void match() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 10);

        int matchCount = LottoMachine.getInstance().match(lotto, winningNumbers);

        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void calculateProfitRate() {
        Map<Integer, Integer> prizeCountMap = new HashMap<>();
        prizeCountMap.put(3, 1);
        prizeCountMap.put(4, 1);
        prizeCountMap.put(5, 0);
        prizeCountMap.put(6, 0);

        assertThat(LottoMachine.getInstance().calculateProfitRate(prizeCountMap, 20000))
                .isEqualTo("2.75");
    }
}

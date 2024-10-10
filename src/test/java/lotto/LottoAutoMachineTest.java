package lotto;

import lotto.constant.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoAutoMachine;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoMachineTest {

    @Test
    void create() {
        LottoMachine machine = new LottoAutoMachine(10000);
        List<Lotto> lottoList = machine.create();
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test
    void match() {
        LottoMachine machine = new LottoAutoMachine(10000);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 10);

        int matchCount = machine.match(lotto, winningNumbers);

        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void calculateProfitRate() {
        EnumMap<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);
        prizeCountMap.put(Prize.FOURTH, 1);
        prizeCountMap.put(Prize.THIRD, 1);
        prizeCountMap.put(Prize.SECOND, 0);
        prizeCountMap.put(Prize.FIRST, 0);
        LottoMachine machine = new LottoAutoMachine(20000);

        assertThat(machine.calculateProfitRate(prizeCountMap))
                .isEqualTo("2.75");
    }
}

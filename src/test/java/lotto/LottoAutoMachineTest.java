package lotto;

import lotto.constant.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoMachineTest {

    @Test
    @DisplayName("로또 자동 생성 테스트")
    void create() {
        LottoMachine machine = LottoMachine.of(10000);
        List<Lotto> lottoList = machine.createAutomatically();
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    void checkLottoPrize() {
        LottoMachine machine = LottoMachine.of(5000);

        EnumMap<Prize, Integer> map = machine.checkLottoPrize(
                List.of(
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(Set.of(1, 2, 3, 4, 6, 7)),
                        new Lotto(Set.of(1, 2, 3, 10, 11, 12)),
                        new Lotto(Set.of(1, 2, 3, 4, 10, 11))
                ),
                Set.of(1, 2, 3, 4, 5, 6)
        );

        assertThat(map.get(Prize.FIRST)).isEqualTo(1);
        assertThat(map.get(Prize.SECOND)).isEqualTo(2);
        assertThat(map.get(Prize.THIRD)).isEqualTo(1);
        assertThat(map.get(Prize.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRate() {
        EnumMap<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);
        prizeCountMap.put(Prize.FOURTH, 1);
        prizeCountMap.put(Prize.THIRD, 1);
        prizeCountMap.put(Prize.SECOND, 0);
        prizeCountMap.put(Prize.FIRST, 0);
        LottoMachine machine = LottoMachine.of(20000);

        assertThat(machine.calculateProfitRate(prizeCountMap, 2))
                .isEqualTo("2.75");
    }
}

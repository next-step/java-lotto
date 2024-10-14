package lotto;

import lotto.constant.Prize;
import lotto.domain.CashAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoCreateByMission;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNo;
import lotto.domain.ManualAmount;
import lotto.domain.MissionProfitRateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 자동 생성 테스트")
    void create() {
        LottoMachine machine = LottoMachine.of(new CashAmount(10000), new ManualAmount(0)
                , new MissionProfitRateStrategy(), new LottoCreateByMission());
        List<Lotto> lottoList = machine.createAutomatically();
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 수동 생성 테스트")
    void createManually() {
        LottoMachine machine = LottoMachine.of(new CashAmount(10000), new ManualAmount(1)
                , new MissionProfitRateStrategy(), new LottoCreateByMission());
        Set<LottoNo> set = IntStream.rangeClosed(1, 6).mapToObj(LottoNo::new).collect(Collectors.toSet());
        Lotto lotto = machine.createManually(set);
//        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(
                new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6));
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    void checkLottoPrize() {
        LottoMachine machine = LottoMachine.of(new CashAmount(5000), new ManualAmount(0)
                , new MissionProfitRateStrategy(), new LottoCreateByMission());

        EnumMap<Prize, Integer> map = machine.checkLottoPrize(
                List.of(
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(5), new LottoNo(6))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(5), new LottoNo(20))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(6), new LottoNo(7))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(10), new LottoNo(11), new LottoNo(12))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(10), new LottoNo(11)))
                ),
                Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                        , new LottoNo(4), new LottoNo(5), new LottoNo(6)),new LottoNo(0));

        assertThat(map.get(Prize.FIRST)).isEqualTo(1);
        assertThat(map.get(Prize.THIRD)).isEqualTo(2);
        assertThat(map.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(map.get(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 2등 당첨 테스트")
    void checkSecondPrize() {
        LottoMachine machine = LottoMachine.of(new CashAmount(5000), new ManualAmount(0)
                , new MissionProfitRateStrategy(), new LottoCreateByMission());

        EnumMap<Prize, Integer> map = machine.checkLottoPrize(
                List.of(
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(5), new LottoNo(6))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(5), new LottoNo(20))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(6), new LottoNo(7))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(10), new LottoNo(11), new LottoNo(12))),
                        new Lotto(Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                                , new LottoNo(4), new LottoNo(10), new LottoNo(11)))
                ),
                Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                        , new LottoNo(4), new LottoNo(5), new LottoNo(6)), new LottoNo(20));

        assertThat(map.get(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRate() {
        EnumMap<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);
        prizeCountMap.put(Prize.FIFTH, 1);
        prizeCountMap.put(Prize.FOURTH, 1);
        prizeCountMap.put(Prize.THIRD, 0);
        prizeCountMap.put(Prize.SECOND, 1);
        prizeCountMap.put(Prize.FIRST, 0);
        LottoMachine machine = LottoMachine.of(new CashAmount(20_000_000), new ManualAmount(0)
                , new MissionProfitRateStrategy(), new LottoCreateByMission());

        assertThat(machine.calculateProfitRate(prizeCountMap))
                .isEqualTo("1.50");
    }
}

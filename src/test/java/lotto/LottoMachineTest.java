package lotto;

import lotto.constant.Prize;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoCreateByMission;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNo;
import lotto.domain.MissionProfitRateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 자동 생성 테스트")
    void create() {
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(10000))
                .manualAmount(new Amount(0))
                .lottoCreateStrategy(new LottoCreateByMission())
                .build();
        List<Lotto> lottoList = machine.createAutomatically();
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 수동 생성 테스트")
    void createManually() {
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(10000))
                .manualAmount(new Amount(1))
                .lottoCreateStrategy(new LottoCreateByMission())
                .build();
        Set<LottoNo> set = IntStream.rangeClosed(1, 6).mapToObj(LottoNo::of).collect(Collectors.toSet());
        Lotto lotto = machine.createManually(set);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(
                LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                , LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    void checkLottoPrize() {
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(5000))
                .manualAmount(new Amount(0))
                .lottoCreateStrategy(new LottoCreateByMission())
                .build();

        EnumMap<Prize, Integer> map = machine.checkLottoPrize(
                List.of(
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(5), LottoNo.of(6))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(5), LottoNo.of(20))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(6), LottoNo.of(7))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(10), LottoNo.of(11), LottoNo.of(12))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(10), LottoNo.of(11)))
                )
                ,Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                        , LottoNo.of(4), LottoNo.of(5), LottoNo.of(6))
                , LottoNo.of(45));

        assertThat(map.get(Prize.FIRST)).isEqualTo(1);
        assertThat(map.get(Prize.THIRD)).isEqualTo(2);
        assertThat(map.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(map.get(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 2등 당첨 테스트")
    void checkSecondPrize() {
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(5000))
                .manualAmount(new Amount(0))
                .lottoCreateStrategy(new LottoCreateByMission())
                .build();

        EnumMap<Prize, Integer> map = machine.checkLottoPrize(
                List.of(
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(5), LottoNo.of(6))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(5), LottoNo.of(20))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(6), LottoNo.of(7))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(10), LottoNo.of(11), LottoNo.of(12))),
                        new Lotto(Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                                , LottoNo.of(4), LottoNo.of(10), LottoNo.of(11)))
                ),
                Set.of(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3)
                        , LottoNo.of(4), LottoNo.of(5), LottoNo.of(6)), LottoNo.of(20));

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
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(20_000_000))
                .profitRateStrategy(new MissionProfitRateStrategy())
                .build();

        assertThat(machine.calculateProfitRate(prizeCountMap))
                .isEqualTo("1.50");
    }
}

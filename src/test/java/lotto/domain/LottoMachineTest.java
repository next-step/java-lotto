package lotto.domain;

import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.domain.generator.MergedGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {

  List<List<Integer>> manualLottos;

  @BeforeEach
  void setUp() {
    manualLottos = new ArrayList<>();
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    manualLottos.add(Arrays.asList(7, 8, 9, 10, 11, 12));
  }

  @Test
  @DisplayName("수동 + 자동 발급 확인")
  public void generatedLotto() {
    Money money = new Money(14000);
    List<LottoGenerator> generators = new ArrayList<>();
    generators.add(new ManualLottoGenerator(manualLottos, money));
    generators.add(new AutoLottoGenerator(money));
    LottoGenerator lottoGenerator = new MergedGenerator(generators);
    LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

    assertThat(lottoMachine.getLottoCount()).isEqualTo(14);

  }

  @Test
  @DisplayName("수동 발급")
  public void generatedManualLotto() {
    Money money = new Money(2000);
    LottoMachine lottoMachine = new LottoMachine(
        new ManualLottoGenerator(manualLottos, money));

    assertThat(lottoMachine.getLottoCount()).isEqualTo(2);

  }

  @Test
  @DisplayName("자동 발급")
  public void generatedAutoLotto() {
    Money money = new Money(14000);
    LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator(money));
    assertThat(lottoMachine.getLottoCount()).isEqualTo(14);
  }


  @Test
  @DisplayName("당첨 통계 확인")
  public void makeMatchingCount() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    lottos.add(Lotto.of(Arrays.asList(34, 25, 35, 32, 43, 12)));
    LottoMachine lottoMachine = new LottoMachine(lottos);

    LastWinningLotto lastWeekWinningLotto = LastWinningLotto
        .of(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
    LottoStaticResult actual = lottoMachine.makeMatchingCount(lastWeekWinningLotto);

    Map<LottoRank, Integer> expectedMap = new HashMap<>();
    expectedMap.put(LottoRank.FIRST, 1);
    expectedMap.put(LottoRank.SECOND, 0);
    expectedMap.put(LottoRank.THIRD, 0);
    expectedMap.put(LottoRank.FOURTH, 0);
    expectedMap.put(LottoRank.FIFTH, 0);
    expectedMap.put(LottoRank.ZERO, 0);

    assertEquals(expectedMap, actual.getlottoStaticResultMap());
  }

  @Test
  @DisplayName("중복 로또 발급 확인")
  public void validateDuplicated() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoMachine lottoMachine = new LottoMachine(lottos);
    });
  }
}

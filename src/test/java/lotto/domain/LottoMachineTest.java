package lotto.domain;

import lotto.domain.generator.DefaultGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {

  @Test
  @DisplayName("수동 + 자동 발급 확인")
  public void generatedLotto() {
    List<List<Integer>> manualLottos = new ArrayList<List<Integer>>();
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));

    LottoMachine lottoMachine = new LottoMachine(new Money(14000),
        new DefaultGenerator(manualLottos));

    assertThat(lottoMachine.getLottoCount()).isEqualTo(14);
  }


  @Test
  @DisplayName("당첨 통계 확인")
  public void makeMatchingCount() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    lottos.add(Lotto.of(Arrays.asList(34, 25, 35, 32, 43, 12)));
    LottoMachine lottoMachine = new LottoMachine(lottos);

    LastWinningLotto lastWeekWinningLotto = LastWinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
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

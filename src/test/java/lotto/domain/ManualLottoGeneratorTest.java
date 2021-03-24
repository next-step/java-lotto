package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.generator.ManualLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottoGeneratorTest {

  @Test
  @DisplayName("수동 발급")
  public void generatedManualLottos() {

    List<List<Integer>> manualLottos = new ArrayList<List<Integer>>();
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    manualLottos.add(Arrays.asList(34,25,35,32,43,12));
    ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLottos);

    List<Lotto> expected = new ArrayList<>();
    expected.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    expected.add(Lotto.of(Arrays.asList(34, 25, 35, 32, 43, 12)));
    assertEquals(expected, manualLottoGenerator.generatedLottoList());
  }
}

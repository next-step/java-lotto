package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.Generator;
import lotto.domain.generator.ManualLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

  @Test
  @DisplayName("수동 + 자동 발급")
  public void generatedLotto2() {
    List<List<Integer>> manualLottos = new ArrayList<List<Integer>>();
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    manualLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    Generator generator = new Generator(new ManualLottoGenerator(manualLottos));
    List<Lotto> lottos = generator.composite(new Money(14000));
    assertThat(lottos.size()).isEqualTo(14);
  }

  @Test
  @DisplayName("수동 발급")
  public void manualLotto() {

    List<List<Integer>> manualLottoInput = new ArrayList<List<Integer>>();
    manualLottoInput.add(Arrays.asList(1, 2, 3, 4, 5, 6));
    manualLottoInput.add(Arrays.asList(34,25,35,32,43,12));
    Generator generator = new Generator(new ManualLottoGenerator(manualLottoInput));
    List<Lotto> manualLottos = generator.manualLotto();


    List<Lotto> expected = new ArrayList<>();
    expected.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    expected.add(Lotto.of(Arrays.asList(34, 25, 35, 32, 43, 12)));

    assertEquals(expected,manualLottos);

  }

  @Test
  @DisplayName("자동 발급")
  public void autoLotto() {
    Generator generator = new Generator();
    List<Lotto> autoLottos = generator.autoLotto(5);
    assertEquals(5,autoLottos.size());

  }

}

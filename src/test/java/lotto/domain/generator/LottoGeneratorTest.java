package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
  public static class TestLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
      return new Lotto(List.of(
              new LottoNumber(1),
              new LottoNumber(45),
              new LottoNumber(2),
              new LottoNumber(44),
              new LottoNumber(3),
              new LottoNumber(43)
      ));
    }
  }

  @DisplayName("수동으로 로또를 생성할 수 있다.")
  @Test
  void testGenerateManualLotto() {
    ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ));
    Lotto actual = manualLottoGenerator.generate();

    assertThat(actual.getNumberRepresentation()).isEqualTo("[1, 2, 3, 4, 5, 6]");
  }
}
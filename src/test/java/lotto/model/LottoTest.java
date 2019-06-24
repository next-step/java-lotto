package lotto.model;

import lotto.model.Lotto;
import lotto.model.MockNumberGenerator;
import lotto.model.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @Test
  void lottoHasNumbers() {
    NumberGenerator numberGenerator = new MockNumberGenerator();
    List<Integer> lottoNumbers = numberGenerator.generate(6);

    Lotto lotto = new Lotto(lottoNumbers);
    assertThat(lotto.toString()).contains("1", "2", "3", "4", "5", "6");
  }
}

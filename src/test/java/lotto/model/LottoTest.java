package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @Test
  @ValueSource(ints = {1,2,3,4,5,6})
  @DisplayName("로또가 가지고 있는 번호 확인")
  void lottoHasNumbers(int value) {
    NumberGenerator numberGenerator = new MockNumberGenerator();
    List<Integer> lottoNumbers = numberGenerator.generate(6);

    Lotto lotto = new Lotto(lottoNumbers);
    assertThat(lotto.contains(value)).isTrue();
  }
}

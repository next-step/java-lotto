package lotto.model;

import lotto.exception.ConflictLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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

  @Test
  @DisplayName("로또 번호 중에 중복되는 번호가 있는지 확인")
  void conflictLottoNumber() {
    assertThatExceptionOfType(ConflictLottoNumberException.class).isThrownBy(() -> {
      List<Integer> lottoNumbers = Arrays.asList(1,2,3,3,2,1);
      new Lotto(lottoNumbers);
    });
  }
}

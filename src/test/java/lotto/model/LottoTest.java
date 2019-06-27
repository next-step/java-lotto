package lotto.model;

import lotto.exception.DuplicatetLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  @DisplayName("로또가 가지고 있는 번호 확인")
  void lottoHasNumbers(int value) {
    NumberGenerator numberGenerator = new MockNumberGenerator();
    List<LottoNumber> lottoNumbers = numberGenerator.generate(6);

    Lotto lotto = new Lotto(lottoNumbers);
    assertThat(lotto.contains(new LottoNumber(value))).isTrue();
  }

  @Test
  @DisplayName("로또 번호 중에 중복되는 번호가 있는지 확인")
  void conflictLottoNumber() {
    assertThatExceptionOfType(DuplicatetLottoNumberException.class).isThrownBy(() -> {
      List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 3, 2, 1).map(LottoNumber::new).collect(Collectors.toList());
      new Lotto(lottoNumbers);
    });
  }
}

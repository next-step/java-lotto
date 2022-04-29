package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoNumberGeneratorTest {

  @RepeatedTest(100)
  @DisplayName("로또번호 범위 내에서 잘 생성되는지 확인")
  void range() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    assertThat(lottoNumberGenerator.generate()).isLessThanOrEqualTo(LottoNumber.MAX)
        .isGreaterThanOrEqualTo(LottoNumber.MIN);
  }

  @RepeatedTest(100)
  @DisplayName("중복되는 번호가 나오는지 확인")
  void duplicate() {
    List<Integer> generateNumbers = new ArrayList<>();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    for (int i = 0; i < 5; i++) {
      generateNumbers.add(lottoNumberGenerator.generate());
    }

    assertThat(generateNumbers.size()).isEqualTo(new HashSet<Integer>(generateNumbers).size());
  }
}
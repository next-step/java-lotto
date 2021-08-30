package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

  @Test
  @DisplayName("랜덤한 로또 번호 생성 테스트")
  void generateByRandomTest() {
    //when
    List<LottoNumber> lottoNumbers = LottoNumbersGenerator.generateByRandom();

    //then
    assertThat(lottoNumbers.size()).isEqualTo(LottoNumbers.SIZE);
    assertThat(lottoNumbers.stream().distinct().count() == lottoNumbers.size()).isTrue();
  }
}

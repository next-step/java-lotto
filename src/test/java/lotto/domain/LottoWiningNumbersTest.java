package lotto.domain;

import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWiningNumbersTest {

  @Test
  @DisplayName("로또 당첨 번호를 생성한다.")
  void generate() {
    // given

    // when
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(new SixLottoNumbers());

    // then
    assertThat(lottoWiningNumbers).isNotNull();
  }

  @Test
  @DisplayName("문자열 입력시에 로또 당첨 번호를 생성한다.")
  void generate_StringInput() {
    // given

    // when
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate("1, 2, 3, 4, 5, 6");

    // then
    assertThat(lottoWiningNumbers)
            .isNotNull()
            .isEqualTo(LottoWiningNumbers.generate(() -> Arrays.asList(1, 2, 3, 4, 5, 6)
                    .stream().map(LottoNumber::generate)
                    .collect(Collectors.toList())));
  }
}
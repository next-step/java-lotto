package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumberParserTest {

  @DisplayName("로또 번호를 입력받아 로또 번호 객체 리스트로 변환한다.")
  @Test
   void parse() {
    String numberLine = "1, 2, 3, 4, 5, 6";

    List<LottoNumber> lottoNumbers = LottoNumberParser.parse(numberLine);

    assertThat(lottoNumbers).containsExactly(
      new LottoNumber(1),
      new LottoNumber(2),
      new LottoNumber(3),
      new LottoNumber(4),
      new LottoNumber(5),
      new LottoNumber(6)
    );
  }
}
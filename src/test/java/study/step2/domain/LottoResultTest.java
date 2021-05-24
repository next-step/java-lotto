package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

  @DisplayName("로또 결과 맞춘 갯수 테스트")
  @Test
  void lottoResult() {
    // given
    LottoResult lottoResult = new LottoResult();

    // when
    lottoResult.add(Rank.THIRD);
    lottoResult.add(Rank.THIRD);

    // then
    assertThat(lottoResult.getValue(Rank.THIRD)).isEqualTo(2);
  }

  @DisplayName("로또 결과 맞춘 갯수 실패 테스트")
  @Test
  void lottoResultFail() {
    // given
    LottoResult lottoResult = new LottoResult();

    // when
    lottoResult.add(Rank.THIRD);
    lottoResult.add(Rank.THIRD);

    // then
    assertThat(lottoResult.getValue(Rank.FIRST)).isEqualTo(0);
  }

}

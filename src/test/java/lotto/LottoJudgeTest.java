package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoJudgeTest {

  @DisplayName("당첨번호와 일치하는 개수를 반환한다.")
  @Test
  void judgeCount() {
    Lotto winningLotto = new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ));
    Lotto lotto = new Lotto(List.of(
            new LottoNumber(5),
            new LottoNumber(6),
            new LottoNumber(7),
            new LottoNumber(8),
            new LottoNumber(9),
            new LottoNumber(10)
    ));
    LottoJudge lottoJudge = new LottoJudge(winningLotto);

    int count = lottoJudge.judgeCount(lotto);

    assertThat(count).isEqualTo(2);
  }
}

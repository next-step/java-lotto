package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
  @Test
  public void 당첨_번호를_이용해_결과목록을_반환() {
    Lottos lottos = new Lottos(List.of(
            Lotto.of(LottoBall.of(7), LottoBalls.of(1, 2, 3, 4, 5, 6)),
            Lotto.of(LottoBall.of(7), LottoBalls.of(1, 2, 3, 4, 5, 7)),
            Lotto.of(LottoBall.of(9), LottoBalls.of(1, 2, 3, 4, 7, 8)),
            Lotto.of(LottoBall.of(11), LottoBalls.of(1, 2, 7, 8, 9, 10))
    ));

    assertThat(lottos.results(Lottery.of(LottoBall.of(7), LottoBalls.of(1, 2, 3, 4, 5, 6)))).isEqualTo(
            new Results(List.of(
                    Result.of(PositiveNumber.of(6), true),
                    Result.of(PositiveNumber.of(5), true),
                    Result.of(PositiveNumber.of(4), false),
                    Result.of(PositiveNumber.of(2), false)
            ))
    );
  }
}

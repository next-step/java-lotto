package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
  @Test
  public void 당첨_번호를_이용해_결과목록을_반환() {
    Lottos lottos = new Lottos(List.of(
            Lotto.of(LottoBalls.of(1, 2, 3, 4, 5, 6, 7)),
            Lotto.of(LottoBalls.of(1, 2, 3, 4, 5, 7, 7)),
            Lotto.of(LottoBalls.of(1, 2, 3, 4, 7, 8, 9)),
            Lotto.of(LottoBalls.of(1, 2, 7, 8, 9, 10, 11))
    ));

    assertThat(lottos.results(LottoBalls.of(1, 2, 3, 4, 5, 6, 7))).isEqualTo(
            new Results(List.of(
                    Result.of(PositiveNumber.of(6), true),
                    Result.of(PositiveNumber.of(5), true),
                    Result.of(PositiveNumber.of(4), false),
                    Result.of(PositiveNumber.of(2), false)
            ))
    );
  }
}

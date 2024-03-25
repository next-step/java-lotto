package lotto.domain;

import lotto.domain.PositiveNumber;
import lotto.domain.Prize;
import lotto.domain.Result;
import lotto.domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ResultsTest {
  @Test
  void 통계_반환() {
    Results results = new Results(List.of(
            Result.of(1, false),
            Result.of(1, false),
            Result.of(2, true),
            Result.of(3, true),
            Result.of(3, false),
            Result.of(4, false),
            Result.of(5, false),
            Result.of(5, true),
            Result.of(6, false),
            Result.of(6, true)
    ));

    Assertions.assertThat(results.stats()).isEqualTo(
            Map.of(
                    Prize.FIRST, PositiveNumber.of(2),
                    Prize.SECOND, PositiveNumber.of(1),
                    Prize.THIRD, PositiveNumber.of(1),
                    Prize.FORTH, PositiveNumber.of(1),
                    Prize.FIFTH, PositiveNumber.of(2)
            )
    );
  }
}

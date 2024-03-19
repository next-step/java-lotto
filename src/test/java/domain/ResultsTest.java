package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ResultsTest {
  @Test
  void 통계_반환() {
    Results results = new Results(List.of(
            new Result(PositiveNumber.of(1)),
            new Result(PositiveNumber.of(1)),
            new Result(PositiveNumber.of(2)),
            new Result(PositiveNumber.of(2)),
            new Result(PositiveNumber.of(3)),
            new Result(PositiveNumber.of(4)),
            new Result(PositiveNumber.of(5)),
            new Result(PositiveNumber.of(5)),
            new Result(PositiveNumber.of(6)),
            new Result(PositiveNumber.of(6)),
            new Result(PositiveNumber.of(6))
    ));
    Assertions.assertThat(results.stats()).isEqualTo(
            Map.of(
                    new Result(PositiveNumber.of(3)), PositiveNumber.of(1),
                    new Result(PositiveNumber.of(4)), PositiveNumber.of(1),
                    new Result(PositiveNumber.of(5)), PositiveNumber.of(2),
                    new Result(PositiveNumber.of(6)), PositiveNumber.of(3)
            )
    );
  }
}

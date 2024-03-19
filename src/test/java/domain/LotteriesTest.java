package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteriesTest {
  @Test
  public void 당첨_번호를_이용해_결과목록을_반환() {
    Lotteries lotteries = new Lotteries(List.of(
            Lottery.of(LotteryNumbers.of(1, 2, 3, 4, 5, 6)),
            Lottery.of(LotteryNumbers.of(1, 2, 3, 4, 5, 7)),
            Lottery.of(LotteryNumbers.of(1, 2, 3, 4, 7, 8)),
            Lottery.of(LotteryNumbers.of(1, 2, 7, 8, 9, 10))
    ));

    assertThat(lotteries.results(LotteryNumbers.of(1, 2, 3, 4, 5, 6))).isEqualTo(
            new Results(List.of(
                    Result.of(PositiveNumber.of(6)),
                    Result.of(PositiveNumber.of(5)),
                    Result.of(PositiveNumber.of(4)),
                    Result.of(PositiveNumber.of(2))
            ))
    );
  }
}

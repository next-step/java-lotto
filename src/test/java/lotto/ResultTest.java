package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResultTest {

  @Test
  void add_성공() {
    LottoPrize target = LottoPrize.SIX;
    Map<LottoPrize, Integer> resultMap = new HashMap<>();
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      if (lottoPrize == target) {
        resultMap.put(target, 1);
        continue;
      }
      resultMap.put(lottoPrize, 0);
    }
    Result expected = new Result(resultMap);
    Result result = new Result();

    result.add(target);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void getMatchedLottoCount_성공() {
    Result result = new Result();
    LottoPrize target = LottoPrize.SIX;
    result.add(target);

    assertThat(result.getMatchedLottoCount(target)).isEqualTo(1);
  }

  @Test
  void equals_성공() {
    Map<LottoPrize, Integer> resultMap = new HashMap<>();
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      resultMap.put(lottoPrize, 1);
    }
    Result expected = new Result(resultMap);

    Result result = new Result();
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      result.add(lottoPrize);
    }

    assertThat(result).isEqualTo(expected);
  }
}

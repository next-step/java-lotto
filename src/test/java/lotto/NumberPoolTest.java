package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberPoolTest {

  PublishStrategy strategy = new PublishStrategy() {
    @Override
    public List<LottoNumber> publish() {
      return null;
    }

    @Override
    public LottoNumberBundle publish1() {
      return IntStream
          .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE)
          .mapToObj(LottoNumber::get)
          .collect(collectingAndThen(toList(), LottoNumberBundle::of));
    }
  };

  @Test
  @DisplayName("로또 번들이 정상적으로 생성 되는지에 대한 테스트")
  void publishTicket() {
    LottoNumberBundle expected = IntStream
        .range(MINIMUM_LOTTO_NUMBER, MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE)
        .mapToObj(LottoNumber::get)
        .collect(collectingAndThen(toList(), LottoNumberBundle::of));

    assertThat(NumberPool.generateNumberBundle1(strategy))
        .isEqualTo(expected);
  }
}

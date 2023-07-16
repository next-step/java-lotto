package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosCountTest {

    @Test
    @DisplayName("양수의 lottos의 개수가 들어오면 생성에 성공한다.")
    void create() {
        long count = 3;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottosCount(count));
    }

    @Test
    @DisplayName("음수의 lottos의 개수가 들어오면 예외가 발생한다.")
    void createException() {
        long minusCount = -3;

        Assertions.assertThatThrownBy(() -> new LottosCount(minusCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottosCount에서 lottosCount를 뺄 수 있다.")
    void subtractLottosCount() {
        LottosCount lottosCount = new LottosCount(10);
        LottosCount anotherLottosCount = new LottosCount(5);

        Assertions.assertThat(lottosCount.subtract(anotherLottosCount)).isEqualTo(new LottosCount(5));
    }

    @Test
    @DisplayName("로또의 개수를 바탕으로 stream을 만들어준다.")
    void makeStream() {
        LottosCount lottosCount = new LottosCount(10);

        Assertions.assertThat(lottosCount.makeLottosCountToLongStream().count()).isEqualTo(10L);
    }
}

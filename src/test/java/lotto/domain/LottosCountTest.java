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
    @DisplayName("돈이 주어지면 남은 돈으로 사야되는 로또의 개수를 리턴한다.")
    void findAnotherCount() {
        Money money = new Money(5000);
        LottosCount lottosCount = new LottosCount(1);

        Assertions.assertThat(lottosCount.findAnotherCount(money)).isEqualTo(new LottosCount(4));
    }

    @Test
    @DisplayName("입력으로 들어온 수와 로또의 개수가 맞다면 true를 리턴한다.")
    void isSameLottoCount() {
        LottosCount lottosCount = new LottosCount(1);

        Assertions.assertThat(lottosCount.isSameLottosCount(1)).isTrue();
    }

    @Test
    @DisplayName("입력으로 들어온 수와 로또의 개수가 다르다면 false를 리턴한다.")
    void isNotSameLottoCount() {
        LottosCount lottosCount = new LottosCount(2);

        Assertions.assertThat(lottosCount.isSameLottosCount(1)).isFalse();
    }

    @Test
    @DisplayName("로또의 개수를 바탕으로 자동 로또들을 생성한다.")
    void autoLottosGenerate() {
        LottosCount lottosCount = new LottosCount(2);

        Assertions.assertThat(lottosCount.generateRandomLottos().size()).isEqualTo(2);
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

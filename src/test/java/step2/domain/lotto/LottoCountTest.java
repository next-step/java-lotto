package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @DisplayName("add 메소드 테스트")
    @Test
    void add() {
        LottoCount lottoCount = new LottoCount(1);
        LottoCount actual = lottoCount.add(new LottoCount(1));
        Assertions.assertThat(actual).isEqualTo(new LottoCount(2));
    }

    @DisplayName("subtract 메소드 테스트")
    @Test
    void subtract() {
        LottoCount lottoCount = new LottoCount(1);
        LottoCount actual = lottoCount.subtract(new LottoCount(1));
        Assertions.assertThat(actual).isEqualTo(new LottoCount(0));
    }

    @DisplayName("subtract 결과가 0보다 작을 경우")
    @Test
    void subtractResultIsZeroOrLess() {
        Assertions.assertThatThrownBy(() -> new LottoCount(1).subtract(new LottoCount(2)));
    }

    @DisplayName("isBiggerThan 메소드 테스트")
    @Test
    void isBiggerThan() {
        LottoCount lottoCount1 = new LottoCount(1);
        LottoCount lottoCount2 = new LottoCount(2);
        Assertions.assertThat(lottoCount2.isBiggerThan(lottoCount1)).isTrue();
    }
}

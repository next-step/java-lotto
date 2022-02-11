package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "14000, 14", "999000, 999"})
    void 금액에_따른_로또_개수를_출력한다(int value, int count) {
        Money money = new Money(String.valueOf(value));
        LottoCount lottoCount = LottoCount.from(money);
        assertThat(lottoCount.count()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "1000, 1000"})
    void 숫자_문자열에_따른_로또_개수를_출력한다(String lottoCount, int count) {
        LottoCount actual = LottoCount.from(lottoCount);
        assertThat(actual.count()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "panda"})
    void 문자는_예외가_발생한다(String lottoCount) {
        assertThatThrownBy(() -> LottoCount.from(lottoCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 갯수는_0이하의_값은_들어올_수_없다(String lottoCount) {
        assertThatThrownBy(() -> LottoCount.from(lottoCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1, 3", "1000, 500, 500"})
    void 두_개수의_차를_구할_수_있다(String lottoCount1, String lottoCount2, String answer) {
        LottoCount leftCount = LottoCount.from(lottoCount1);
        LottoCount rightCount = LottoCount.from(lottoCount2);
        LottoCount actual = leftCount.minus(rightCount);
        LottoCount expected = LottoCount.from(answer);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "500, 1000"})
    void 더_큰_수로_뺄_수_없다(String lottoCount1, String lottoCount2) {
        LottoCount leftCount = LottoCount.from(lottoCount1);
        LottoCount rightCount = LottoCount.from(lottoCount2);
        assertThatThrownBy(() -> leftCount.minus(rightCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("더 큰");
    }
}

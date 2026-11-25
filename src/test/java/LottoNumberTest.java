import domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {


    @Test
    void 번호가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호가_45_초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "?", "삼", "1.5"})
    void 문자열이_비어있거나_숫자가_아니면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_양옆의_공백은_제거된다() {
        assertThat(new LottoNumber(" 7 ")).isEqualTo(new LottoNumber(7));
    }


    @Test
    void 값이_같으면_동등하다() {
        assertThat(new LottoNumber(7)).isEqualTo(new LottoNumber(7));
        assertThat(new LottoNumber(7)).hasSameHashCodeAs(new LottoNumber(7));
    }
}
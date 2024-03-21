package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    public void 로또_번호는_1보다_작을_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber nums = new LottoNumber(0);
        });
    }

    @Test
    public void 로또_번호는_45보다_클_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber nums = new LottoNumber(46);
        });
    }
}

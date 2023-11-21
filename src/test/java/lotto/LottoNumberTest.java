package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoNumberTest {

    private LottoNumber lottoNumber;

    void setup(int number){
        this.lottoNumber = new LottoNumber(number);
    }
    @Test
    void 숫자를_가진다() {
        setup(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 숫자는_1_과_45_사이에_있어야한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> setup(0));
    }
}

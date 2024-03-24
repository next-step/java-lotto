package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    public void 로또_숫자_개수에_맞지_않으면_Exception을_일으킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers nums = new LottoNumbers("1, 2, 3, 4, 5");
        });
    }

    @Test
    public void null이_오면_Exception을_일으킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers nums = new LottoNumbers((String) null);
        });
    }

    @Test
    public void 구분자가_맞지_않으면_Exception을_일으킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers nums = new LottoNumbers("1,2,3,4,5,6");
        });
    }

    @Test
    void 중복된_번호가_있는_경우_Exception이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers nums = new LottoNumbers("1,1,3,4,5,6");
        });
    }
}

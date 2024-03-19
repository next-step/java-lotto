package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumbersTest {

    @Test
    public void 입력한_숫자들을_리스트로_변환한다() {
        LottoNumbers nums = new LottoNumbers("1, 2, 3, 4, 5, 6");
        List<Integer> expectedNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(nums.getLottoNumbers(), expectedNums);
    }

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
}

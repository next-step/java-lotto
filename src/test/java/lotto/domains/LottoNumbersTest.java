package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumbersTest {
    @Test
    void 생성자_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers).isNotNull();
    }

    @Test
    void 로또번호_음수_45이상숫자_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,2,3,4,5,46)));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(-1,2,3,4,5,45)));
    }

    @Test
    void 로또번호_중복숫자_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5,46)));
    }

    @Test
    void 로또번호_숫재갯수_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5)));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(Arrays.asList(1,1,3,4,5,6,7)));
    }


}

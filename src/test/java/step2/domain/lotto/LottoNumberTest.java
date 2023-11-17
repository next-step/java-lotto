package step2.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    void 로또_번호_생성_테스트() {
        assertThat(new LottoNumber().getNumbers()).hasSize(6);
    }

    @Test
    void 로또_번호_생성_List_테스트_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(Arrays.asList(1, 2)));
    }

    @Test
    void 로또_번호_생성_Set_테스트_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(new HashSet<>(1, 2)));
    }
}

package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoTest {

    @Test
    void 생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 결과() {
        Lotto beforeLotto = Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 7));
        LottoResult result = lotto.getResult(beforeLotto, LottoNumber.of(7));

        assertThat(result).isEqualTo(LottoResult.SECOND);
    }
}
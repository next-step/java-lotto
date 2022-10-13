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
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 결과() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        LottoResult result = lotto.getResult(lotto);

        assertThat(result).isEqualTo(LottoResult.FIRST);
    }
}
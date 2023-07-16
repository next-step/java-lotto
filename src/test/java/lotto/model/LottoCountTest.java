package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoCountTest {

    @Test
    void 로또_개수_값_정상() {
        // given, when, then
        assertThat(new LottoCount(1).getCount()).isEqualTo(1);
    }

    @Test
    void 로또_개수_음수_일시_예외발생() {
        // given, when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoCount(-1));
        assertThat(exception).hasMessage("로또의 개수는 " + 0 + " 이상입니다.");
    }
}

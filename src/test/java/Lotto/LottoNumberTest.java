package lotto;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    void 생성() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 숫자_1_부터_45_까지만_유효() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46)).withMessageContaining("유효하지 않은 로또 번호입니다.");
    }

    @Test
    void 셔플된_로또번호_전체_목록() {
        assertThat(LottoNumber.shuffleNumbers()).containsAll(IntStream.range(1, 46).boxed().map(v -> new LottoNumber(v)).collect(Collectors.toList()));
    }
}

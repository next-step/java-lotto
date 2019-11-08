package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:03
 */
public class LottoTest {
    @Test
    void 생성() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void 로또_번호_갯수_검증() {
        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_번호_검증() {
        assertThatThrownBy(() -> {
            Lotto.of((Arrays.asList(1,2,3,4,5,5)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성_가변인자() {
        Lotto lotto = Lotto.of(1,2,3,4,5,6);
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void 생성_문자열() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
    }
}

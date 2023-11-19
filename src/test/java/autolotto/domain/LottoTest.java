package autolotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void lottoNumbers_로또번호6개생성확인() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNumbers_로또숫자범위확인() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNumbers_당첨갯수확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13));
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        int count = lotto.matchCount(lotto, winLotto);
        assertThat(count).isEqualTo(3);
    }
}
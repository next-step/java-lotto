package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 자동 생성 사이즈 테스트")
    public void autoCreateTest() {

        // when
        Lotto lotto = new Lotto();

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 정렬 테스트")
    public void sortTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 5, 4, 3, 6, 2));

        // then
        assertThat(lotto.getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}

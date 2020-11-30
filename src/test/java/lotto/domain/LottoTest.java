package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    public void initLotto() {
        lotto = new Lotto(Arrays.asList(6, 4, 3, 2, 5, 1));
    }

    @Test
    @DisplayName("로또 자동 생성 사이즈 테스트")
    public void autoCreateTest() {

        lotto = new Lotto();

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 정렬 테스트")
    public void sortTest() {

        // when
        lotto.sort();

        // then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}

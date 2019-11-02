package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 생성() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 당첨여부확인_3개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.findMatchedNumberCount(Arrays.asList(1, 2, 3, 8, 9, 10));
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 당첨여부확인_4개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.findMatchedNumberCount(Arrays.asList(1, 2, 3, 4, 9, 10));
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 당첨여부확인_5개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.findMatchedNumberCount(Arrays.asList(1, 2, 3, 4, 5, 10));
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 당첨여부확인_6개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.findMatchedNumberCount(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(6);
    }
}

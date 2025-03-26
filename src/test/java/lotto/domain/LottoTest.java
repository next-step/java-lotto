package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 미당첨() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 11, 12, 13, 14"), new Number(44))).isEqualTo(Rank.MISS);
    }

    @Test
    void 당첨_5등() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 3, 11, 12, 13"), new Number(44))).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_4등() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 3, 4, 11, 12"), new Number(44))).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 당첨_3등() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 3, 4, 5, 13"), new Number(44))).isEqualTo(Rank.THIRD);
    }

    @Test
    void 당첨_2등() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 3, 4, 5, 13"), new Number(6))).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨_1등() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getRank(Lotto.from("1, 2, 3, 4, 5, 6"), new Number(7))).isEqualTo(Rank.FIRST);
    }

    @Test
    void 로또_순서_검증() {
        Lotto lotto = Lotto.from("6, 5, 4, 3, 2, 1");
        assertThat(lotto.isSorted()).isTrue();
    }
}

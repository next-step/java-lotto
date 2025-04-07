package domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void getLottoNumbers() {
        assertThat(new Lotto().getLottoNumbers()).hasSize(6);
    }

    @Test
    void getHitCount() {
        Lotto lotto = new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(lotto.getHitCount(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        softly.assertThat(lotto.getHitCount(List.of(1, 2, 3, 4, 5, 45))).isEqualTo(5);
        softly.assertThat(lotto.getHitCount(List.of(1, 2, 3, 4, 44, 45))).isEqualTo(4);
        softly.assertThat(lotto.getHitCount(List.of(1, 2, 3, 43, 44, 45))).isEqualTo(3);
        softly.assertThat(lotto.getHitCount(List.of(1, 2, 42, 43, 44, 45))).isEqualTo(2);
        softly.assertThat(lotto.getHitCount(List.of(1, 41, 42, 43, 44, 45))).isEqualTo(1);
        softly.assertThat(lotto.getHitCount(List.of(40, 41, 42, 43, 44, 45))).isEqualTo(0);

        softly.assertAll();
    }

    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.hasBonusNumber(6)).isTrue();
    }

    @Test
    void hasNoBonusNumber() {
        Lotto lotto = new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.hasBonusNumber(7)).isFalse();
    }
}

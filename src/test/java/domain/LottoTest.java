package domain;

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
        Lotto lotto = new Lotto(new LottoNumbers(List.of(1,2,3,4,5,6)));
        assertThat(lotto.getHitCount(List.of(1,2,3,4,5,6))).isEqualTo(6);
        assertThat(lotto.getHitCount(List.of(1,2,3,4,5,45))).isEqualTo(5);
        assertThat(lotto.getHitCount(List.of(1,2,3,4,44,45))).isEqualTo(4);
        assertThat(lotto.getHitCount(List.of(1,2,3,43,44,45))).isEqualTo(3);
        assertThat(lotto.getHitCount(List.of(1,2,42,43,44,45))).isEqualTo(2);
        assertThat(lotto.getHitCount(List.of(1,41,42,43,44,45))).isEqualTo(1);
        assertThat(lotto.getHitCount(List.of(40,41,42,43,44,45))).isEqualTo(0);
    }

    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(new LottoNumbers(List.of(1,2,3,4,5,6)));
        assertThat(lotto.hasBonusNumber(6)).isTrue();
        assertThat(lotto.hasBonusNumber(7)).isFalse();
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 모두 일치")
    void matches_all() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 13, 16, 18, 20)));
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 5개 일치")
    void matches_5() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 13, 15, 18, 20)));
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 4개 일치")
    void matches_4() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 11, 15, 18, 20)));
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 번호 3개 일치")
    void matches_3() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 11, 15, 17, 20)));
        assertThat(result).isEqualTo(3);
    }
}

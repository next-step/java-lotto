package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = Lotto.of(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("로또 번호는 6개이다.")
    void count() {
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void duplicate() {
        assertThatThrownBy(() -> Lotto.of(List.of(1,2,3,4,5,5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

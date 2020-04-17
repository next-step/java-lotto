package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void of() {
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void ofComma() {
        assertThat(lotto).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
    }

    @Test
    public void createLottoWithInsufficientInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = Lotto.of(Arrays.asList(1, 2, 3));
        }).withMessage("로또 번호는 중복되지 않는 6개의 숫자만 가능합니다.");
    }

    @Test
    public void createLottoWithOverFlowInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).withMessage("로또 번호는 중복되지 않는 6개의 숫자만 가능합니다.");
    }

    @Test
    public void createLottoWithDuplicateInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 6, 6));
        }).withMessage("로또 번호는 중복되지 않는 6개의 숫자만 가능합니다.");
    }

    @Test
    public void match() {
        assertAll(
                () -> assertThat(lotto.match(Lotto.of(1, 2, 3, 4, 5, 6))).isEqualTo(6),
                () -> assertThat(lotto.match(Lotto.of(1, 2, 3, 7, 8, 9))).isEqualTo(3),
                () -> assertThat(lotto.match(Lotto.of(7, 8, 9, 10, 11, 12))).isEqualTo(0)
        );
    }
}

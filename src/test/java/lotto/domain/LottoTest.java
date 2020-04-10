package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    public void match_6개_1등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void match_5개_보너스_매치_2등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", 6);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void match_5개_3등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", 8);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void match_4개_4등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,7,8", 9);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void match_3개_5등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,7,8,9", 6);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void match_보너스_포함_3개_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,7,8,9,10", 6);
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.MISS);
    }
}

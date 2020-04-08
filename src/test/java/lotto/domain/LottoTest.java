package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private Lotto lotto;
    private Lotto winningLotto;

    @Test
    public void createOneLotto() {
        lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void createWinningLotto() {
        winningLotto = new Lotto(1, 3, 2, 4, 5, 6);
        Set<Integer> winningNumbers = winningLotto.getLottoNumbers();
        assertThat(winningNumbers).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto).isEqualTo(new Lotto(1, 3, 2, 4, 5, 6));
    }

    @Test
    public void createLottoWithInsufficientInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3);
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }

    @Test
    public void createLottoWithOverFlowInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3, 4, 5, 6, 7, 8, 9);
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }

    @Test
    public void createLottoWithDuplicateInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 1, 2, 3, 4, 7);
        }).withMessage("로또 번호들은 중복될 수 없습니다.");
    }

    @Test
    public void createLottoWithInvalidNumberThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(0, 1, 2, 3, 4, 46);
        }).withMessage("로또 번호는 1부터 45까지만 가능합니다.");
    }

    @Test
    public void createLottoWithString() {
        Lotto lotto = new Lotto(1, 3, 2, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @Test
    public void match_6개_테스트() {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void match_5개_보너스_테스트() {
        lotto = new Lotto(1, 2, 3, 4, 5, 7);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void match_5개_테스트() {
        lotto = new Lotto(1, 2, 3, 4, 5, 8);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void match_3개_테스트() {
        lotto = new Lotto(1, 2, 3, 7, 8, 9);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void match_3개_보너스_일치_테스트() {
        lotto = new Lotto(1, 2, 3, 7, 8, 9);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void match_3개_보너스_포함_테스트() {
        lotto = new Lotto(1, 2, 7, 8, 9, 10);
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        assertThat(lotto.match(winningLotto, bonusNo)).isEqualTo(Rank.MISS);
    }
}

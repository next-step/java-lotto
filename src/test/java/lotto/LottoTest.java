package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {

    @Test
    @DisplayName("당첨 확인 테스트")
    void checkWinning() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));

        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.FIRST);

        lotto = new Lotto(Arrays.asList(10,2,3,4,5,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.THIRD);

        lotto = new Lotto(Arrays.asList(10,20,3,4,5,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.FOURTH);

        lotto = new Lotto(Arrays.asList(10,20,30,4,5,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.FIFTH);

        lotto = new Lotto(Arrays.asList(10,20,30,40,5,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.NONE);

        lotto = new Lotto(Arrays.asList(10,20,30,40,45,6));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.NONE);

        lotto = new Lotto(Arrays.asList(10,20,30,40,45,44));
        assertThat(lotto.checkWinning(winningNumbers)).isEqualTo(LottoRank.NONE);
    }
}
package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    void 중복_보너스입력_예외() {
        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(winningNumber, bonusNumber));
    }

    @Test
    void 당첨_번호_갯수_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(7), new LottoNo(8), new LottoNo(9))), new LottoNo(10));
        Rank rank = winningLotto.matchRank(lotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_번호_갯수_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9))), new LottoNo(6));
        Rank rank = winningLotto.matchRank(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

}
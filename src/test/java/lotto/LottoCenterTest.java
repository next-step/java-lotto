package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoCenterTest {

    @Test
    void 로또_수동_구매() {
        Cash cash = new Cash(14000);
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> lottos = new LottoCenter().manualBuyLotto(cash, manualLottos);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    void 구입_가능_숫자_예외() {
        Cash cash = new Cash(1000);
        int manualCountOver = 2;
        int manualCountUnderZero = -1;
        LottoCenter lottoCenter = new LottoCenter();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoCenter.manualBuyValidCheck(cash, manualCountOver));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoCenter.manualBuyValidCheck(cash, manualCountUnderZero));
    }

    @Test
    void 로또_생성() {
        Cash cash = new Cash(1000);
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> issuedTicket = new LottoCenter().manualBuyLotto(cash, manualLottos);
        Lotto lotto = issuedTicket.get(0);

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void 당첨_여부_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(14), new LottoNo(15), new LottoNo(16)));
        LottoNo bonusNumber = new LottoNo(7);

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        Result ranks = lottoCenter.matchWinningNumbers(lottos);

        assertThat(ranks.countRank(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 당첨_여부_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(9);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        Result ranks = lottoCenter.matchWinningNumbers(lottos);

        assertThat(ranks.countRank(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 통계_당첨_결과() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        lottoCenter.matchWinningNumbers(lottos);

        List<Integer> result = lottoCenter.checkWinningResult();

        assertThat(result.get(0)).isEqualTo(0); //1st
        assertThat(result.get(2)).isEqualTo(1); //3rd
    }

    @Test
    void 통계_당첨_수익률() {
        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoCenter lottoCenter = new LottoCenter(winningLotto);

        Cash cash = new Cash(1000);
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> lottos = lottoCenter.manualBuyLotto(cash, manualLottos);

        lottoCenter.matchWinningNumbers(lottos);
        lottoCenter.checkWinningResult();

        float rate = lottoCenter.checkWinningRate();

        assertThat(rate).isLessThanOrEqualTo(1);
    }
}
package lotto.domain.lotto;

import lotto.common.LottoStub;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLineTest {

    @DisplayName("로또 티켓의 당첨 여부를 확인할 수 있다")
    @Test
    public void checkPrize() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 8), 7);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);

        assertThat(lottoRank.getMatchCount()).isEqualTo(LottoRank.FIVE.getMatchCount());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void returnMatchedNumberCountTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 8), 7);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(winningPrize).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 2개 일치")
    @Test
    public void returnTwoMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 7, 8, 9, 10), 11);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.TWO.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.TWO.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 3개 일치")
    @Test
    public void returnThreeMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 7, 8, 9), 10);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.THREE.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.THREE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 4개 일치")
    @Test
    public void returnFourMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 8, 9), 10);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FOUR.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FOUR.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 5개 일치")
    @Test
    public void returnFiveMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 9), 10);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FIVE.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 5개 + 보너스 일치")
    @Test
    public void returnFiveBonusMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 9), 6);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FIVE_BONUS.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FIVE_BONUS.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 6개 일치")
    @Test
    public void returnSixBonusMatchedNumberTest() {
        LottoLine lottoLine = new LottoLine(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);

        LottoRank lottoRank = lottoLine.checkPrize(winningLotto);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.SIX.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

}

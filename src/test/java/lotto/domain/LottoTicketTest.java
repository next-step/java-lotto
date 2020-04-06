package lotto.domain;

import lotto.common.LottoStub;
import lotto.domain.machine.LottoTicket;
import lotto.domain.matcher.LottoRank;
import lotto.domain.matcher.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 티켓의 당첨 여부를 확인할 수 있다")
    @Test
    public void checkPrize() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 8), 7);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);

        assertThat(lottoRank.getMatchCount()).isEqualTo(LottoRank.FIVE.getMatchCount());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void returnMatchedNumberCountTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 8), 7);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(winningPrize).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 2개 일치")
    @Test
    public void returnTwoMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 7, 8, 9, 10), 11);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.TWO.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.TWO.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 3개 일치")
    @Test
    public void returnThreeMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 7, 8, 9), 10);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.THREE.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.THREE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 4개 일치")
    @Test
    public void returnFourMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 8, 9), 10);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FOUR.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FOUR.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 5개 일치")
    @Test
    public void returnFiveMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 9), 10);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FIVE.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 5개 + 보너스 일치")
    @Test
    public void returnFiveBonusMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 9), 6);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.FIVE_BONUS.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.FIVE_BONUS.getWinningPrize());
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다. - 6개 일치")
    @Test
    public void returnSixBonusMatchedNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);

        LottoRank lottoRank = lottoTicket.checkPrize(winningTicket);
        int matchCount = lottoRank.getMatchCount();
        int winningPrize = lottoRank.getWinningPrize();

        assertThat(matchCount).isEqualTo(LottoRank.SIX.getMatchCount());
        assertThat(winningPrize).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

}

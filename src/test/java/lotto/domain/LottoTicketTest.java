package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 로또_사이즈_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 비정상_사이즈_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_처리확인() {
        LottoTicket lottoTicket = new LottoTicket(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_처리확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 번호중복_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(1));
        }
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
    }

    @Test
    public void 일치개수_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }

        String[] winningNumbers = {"1","2","3","4","5","6"};
        String bonusNumber = "7";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
        int count = lottoTicket.matchCount(winningLotto);
        assertThat(count).isEqualTo(6);
    }

    @Test
    public void 보너스당첨_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }

        String[] winningNumbers = {"1","2","3","4","5","7"};
        String bonusNumber = "6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
        boolean isMatchBonusNumber = lottoTicket.matchBonusNumber(winningLotto);
        assertThat(isMatchBonusNumber).isEqualTo(true);

        lottoTicket.matchCount(winningLotto);
        assertThat(lottoTicket.isBonusMatch()).isEqualTo(true);
    }
}

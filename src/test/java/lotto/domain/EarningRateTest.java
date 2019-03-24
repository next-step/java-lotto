package lotto.domain;

import lotto.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateTest {
    //TODO : 수익률 계산 ( 구매비용, 당첨금 ) -> 수익률
    @Test
    public void 상금_수익률_계산() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }

        String[] winningNumbers = {"1","2","3","4","5","7"};
        String bonusNumber = "6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket(lottoBalls));

        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        LottoMoney lottoMoney = new LottoMoney(1_000);
        EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
        System.out.println(earningRate.toString());
        assertThat(earningRate.toString()).isEqualTo("30000.00");
    }

    @Test
    public void 소수점_수익률_계산() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }

        String[] winningNumbers = {"3","4","5","14","15","17"};
        String bonusNumber = "6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket(lottoBalls));

        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        LottoMoney lottoMoney = new LottoMoney(10_300);
        EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
        System.out.println(earningRate.toString());
        assertThat(earningRate.toString()).isEqualTo("0.49");
    }
}

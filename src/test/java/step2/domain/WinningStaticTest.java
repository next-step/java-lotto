package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class WinningStaticTest {


    @Test
    public void getLottoTotalPrice() {
        MakeLottoFactory makeLotto = new MakeLottoFactory(0);
        Lotto lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        Lotto winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");
        CheckWinning checkWinning = new CheckWinning(winningLotto);

        lotto = checkWinning.setWinningNubmer(lotto);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lotto lotto2 = makeLotto.makeLottoWithString("1,2,3,8,11,13");
        lotto2 = checkWinning.setWinningNubmer(lotto2);
        lottoList.add(lotto2);

        WinningStatistics winningStatistics = new WinningStatistics(lottoList);


        assertThat(winningStatistics.getTotalWinningPrice()).isEqualTo(55000);
    }

    @Test
    public void getBenefitOrNot() {
        MakeLottoFactory makeLotto = new MakeLottoFactory(0);
        Lotto lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        Lotto winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");
        CheckWinning checkWinning = new CheckWinning(winningLotto);

        lotto = checkWinning.setWinningNubmer(lotto);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lotto lotto2 = makeLotto.makeLottoWithString("1,2,3,8,11,13");
        lotto2 = checkWinning.setWinningNubmer(lotto2);
        lottoList.add(lotto2);

        WinningStatistics winningStatistics = new WinningStatistics(lottoList);
//        assertThat(winningStatistics.isBenefit()).isTrue();
        assertThat(winningStatistics.getWinningStatic()).isEqualTo(1.4);
    }
}

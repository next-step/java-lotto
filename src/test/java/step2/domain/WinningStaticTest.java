package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class WinningStaticTest {

    private MakeLottoFactory makeLotto;
    private Lotto lotto;
    private Lotto winningLotto;
    private List<Lotto> lottoList;
    private Lotto lotto2;

    @BeforeEach
    void setUp() {
        makeLotto = new MakeLottoFactory(0);
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        winningLotto= makeLotto.makeLottoWithString("1,2,3,8,9,10");
        lottoList = new ArrayList<>();
        lottoList.add(lotto);
        lotto2 = makeLotto.makeLottoWithString("1,2,3,8,11,13");
        lottoList.add(lotto2);
    }


    @Test
    public void getLottoTotalPrice() {

        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLotto);
        assertThat(winningStatistics.getTotalWinningPrice()).isEqualTo(55000);
    }

    @Test
    public void getBenefitOrNot() {

        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLotto);
//        assertThat(winningStatistics.isBenefit()).isTrue();
        assertThat(winningStatistics.getWinningStatic()).isEqualTo((float)27.5);
    }
}

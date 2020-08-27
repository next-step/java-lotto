package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.MakeLottoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    private LottoFactory makeLotto;
    private Lotto lotto;
    private Lotto winningLotto;
    private List<Lotto> lottoList;
    private Lotto lotto2;
    private WinningStatistics winningStatistics;
    private WinningLotto winningLottoNumbers;

    @BeforeEach
    void setUp() {
        makeLotto = new LottoFactory(0);
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");
        lottoList = new ArrayList<>();
        lottoList.add(lotto);
        lotto2 = makeLotto.makeLottoWithString("1,2,3,8,9,13");
        lottoList.add(lotto2);
        winningLottoNumbers = new WinningLotto(winningLotto, new LottoNumber(13));

        winningStatistics = new WinningStatistics(lottoList, winningLottoNumbers);
    }

    @Test
    public void getLottoTotalPrice() {
        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLottoNumbers);
        assertThat(winningStatistics.getTotalWinningPrice()).isEqualTo(55000);
    }

    @Test
    public void getBenefitOrNot() {
        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLottoNumbers);
        assertThat(winningStatistics.getWinningStatic()).isEqualTo((float) 27.5);
    }

    @Test
    public void checkWinningCount() {
        assertThat(winningLottoNumbers.winningCount(lotto2)).isEqualTo(5);
    }

}

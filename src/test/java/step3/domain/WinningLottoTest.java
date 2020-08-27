package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private LottoFactory makeLotto;
    private Lotto lotto;
    private Lotto winningLotto;
    private List<Lotto> lottoList;
    private Lotto lotto2;
    private WinningStatistics winningStatistics;
    private WinningLotto winningLottoNumbers;
    private LottoNumber bonusNumber;
    private WinningLotto winningLottoTest;

    @BeforeEach
    void setUp() {
        makeLotto = new LottoFactory(0);
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");

        lottoList = new ArrayList<>();
        lottoList.add(lotto);
        lotto2 = makeLotto.makeLottoWithString("1,2,3,8,9,13");
        lottoList.add(lotto2);

        winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");
        winningLottoNumbers = new WinningLotto(winningLotto, new LottoNumber(13));

        winningStatistics = new WinningStatistics(lottoList, winningLottoNumbers);
        bonusNumber = new LottoNumber(13);

        lotto2 = makeLotto.makeLottoWithString("1,2,3,8,9,13");
    }

    @Test
    public void testWinningLotto() {

        assertThat(winningLottoNumbers.winningCount(lotto)).isEqualTo(3);
    }

    @Test
    public void winningCountTest() {
        assertThat(winningLottoNumbers.matchBonus(lotto2)).isTrue();
        assertThat(winningLottoNumbers.matchBonus(lotto)).isFalse();
    }
}

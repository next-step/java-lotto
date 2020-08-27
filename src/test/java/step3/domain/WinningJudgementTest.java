package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningJudgementTest {
    private Map winningMap;
    private LottoFactory makeLotto;
    private Lotto lotto;
    private Lotto winningLotto;
    private List<Lotto> lottoList;
    private Lotto lotto2;
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
        winningMap = new EnumMap(WinningPrice.class);
    }

    @Test
    public void testWinningMap() {
        assertThat(winningMap).isEqualTo(winningMap);
    }
}

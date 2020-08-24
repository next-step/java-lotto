package step2.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckWinningTest {

    private MakeLottoFactory makeLotto;
    private Lotto lotto;
    Lotto winningLotto;
    @BeforeEach
    void setUp() {
        makeLotto = new MakeLottoFactory(0);
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        winningLotto= makeLotto.makeLottoWithString("1,2,3,8,9,10");
    }

    @Test
    @DisplayName("리스트별 당첨번호 값이 같은지 테스트")
    public void checkWinningListTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        Lotto lotto2 = makeLotto.makeLottoWithString("1,2,3,8,11,13");
        lottoList.add(lotto2);

        lottoList = makeLotto.setLottoWinningNumber(lottoList,winningLotto);
        assertThat(lottoList.get(0).getWinningPrice()).isEqualTo(WinningPrice.FOURTH_PRIZE);
    }
}

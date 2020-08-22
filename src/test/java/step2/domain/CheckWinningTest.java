package step2.domain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckWinningTest {
    @Test
    public void checkWinningTest() {
        MakeLottoFactory makeLotto = new MakeLottoFactory(0);
        Lotto lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        Lotto winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");
        CheckWinning checkWinning = new CheckWinning(winningLotto);

        lotto = checkWinning.setWinningNubmer(lotto);
        assertThat(lotto.getWinningCount()).isEqualTo(3);
    }

    @Test
    public void checkWinningListTest() {
        MakeLottoFactory makeLotto = new MakeLottoFactory(0);
        Lotto lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        Lotto winningLotto = makeLotto.makeLottoWithString("1,2,3,8,9,10");

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        Lotto lotto2 = makeLotto.makeLottoWithString("1,2,3,8,11,13");
        lottoList.add(lotto2);

        CheckWinning checkWinning = new CheckWinning(winningLotto,lottoList);
        lottoList = checkWinning.setWinningNumberLottoList();



        assertThat(lottoList.get(0).getWinningCount()).isEqualTo(3);

    }
}

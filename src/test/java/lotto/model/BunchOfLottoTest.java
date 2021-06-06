package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;

public class BunchOfLottoTest {

    @Test
    public void makeRewardTest() {
        String winningNumber = "1,2,3,11,22,33";
        LottoNumber incorrectBonusBall = new LottoNumber(7);

        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);
        BunchOfLotto bunchOfLotto = new BunchOfLotto(1);

        Assertions.assertThat(bunchOfLotto.makeRewards(winningLotto).getClass()).isEqualTo(Prizes.class);
    }
}

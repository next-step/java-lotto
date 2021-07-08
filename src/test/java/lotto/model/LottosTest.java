package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static lotto.util.TypeConverter.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("수동으로 생성된 로또 추가")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void addLottoTest(String inputNumber) {
        Lottos lottos = new Lottos();
        lottos.addLotto(LottoGenerator.makeManualLotto(inputNumber));

        assertThat(lottos.getLottos().size()).isEqualTo(1);
    }

    @DisplayName("자동으로 생성된 로또들 추가")
    @Test
    void addBunchOfLottoTest() {
        Lottos lottos = new Lottos();
        lottos.addLottos(LottoGenerator.makeBunchOfAutoLotto(5));

        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

    @Test
    void makeRewardTest() {
        String winningNumber = "1,2,3,11,22,33";
        LottoNumber incorrectBonusBall = new LottoNumber(7);

        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);
        Lottos lottos = LottoGenerator.makeBunchOfAutoLotto(1);

        assertThat(lottos.makeRewards(winningLotto).getClass()).isEqualTo(Prizes.class);
    }
}

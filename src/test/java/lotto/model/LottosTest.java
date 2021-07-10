package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static lotto.util.TypeConverter.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {
    @DisplayName("수동으로 생성된 로또 추가")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void addLottoTest(String inputNumber) {
        Lottos lottos = new Lottos();
        lottos.addLotto(LottoGenerator.makeManualLotto(inputNumber));

        assertThat(lottos.getLottos()).hasSize(1);
    }

    @DisplayName("자동으로 생성된 로또들 추가")
    @Test
    void addBunchOfLottoTest() {
        Lottos lottos = new Lottos();
        lottos.addLottos(LottoGenerator.makeAutoLottos(5));

        assertThat(lottos.getLottos()).hasSize(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,11,22,33"})
    void makeRewardsTest(String winningNumber) {
        LottoNumber incorrectBonusBall = new LottoNumber(7);
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);

        Lottos lottos = new Lottos();
        String lottoNumbers = "1,2,3,11,44,45";
        Lotto lotto = LottoGenerator.makeManualLotto(lottoNumbers);
        lottos.addLotto(lotto);

        assertAll(
                () -> assertThat(lottos.makePrizes(winningLotto).getPrizes()).hasSize(6),
                () -> assertThat(lottos.makePrizes(winningLotto).getPrizes().get(Reward.FOURTH_PRIZE)).isEqualTo(1)
        );
    }
}

package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.TypeConverter.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void generateWinningLotto(String names) {
        List<String> StringNames = Arrays.asList(names.split(","));
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String name : StringNames) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(name)));
        }

        assertDoesNotThrow(() -> new WinningLotto(lottoNumbers, new LottoNumber(7)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void makeRewardsTest(String winningNumber) {
        LottoNumber incorrectBonusBall = new LottoNumber(7);
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);

        String firstPrizeLottoNumbers = "1,2,3,4,5,6";
        Lotto firstPrizeLotto = LottoGenerator.makeManualLotto(firstPrizeLottoNumbers);
        String secondPrizeLottoNumbers = "1,2,3,4,5,7";
        Lotto secondPrizeLotto = LottoGenerator.makeManualLotto(secondPrizeLottoNumbers);
        String thirdPrizeLottoNumbers = "1,2,3,4,5,8";
        Lotto thirdPrizeLotto = LottoGenerator.makeManualLotto(thirdPrizeLottoNumbers);

        assertAll(
                () -> assertThat(winningLotto.makeReward(firstPrizeLotto)).isEqualTo(Reward.FIRST_PRIZE),
                () -> assertThat(winningLotto.makeReward(secondPrizeLotto)).isEqualTo(Reward.SECOND_PRIZE),
                () -> assertThat(winningLotto.makeReward(thirdPrizeLotto)).isEqualTo(Reward.THIRD_PRIZE)
        );
    }
}


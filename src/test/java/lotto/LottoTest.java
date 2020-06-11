package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.RewardStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void LOTTO_NUMBER_COUNT() {
        assertThat(new Lotto(5).getLottoNumbers()).hasSize(5);
    }

    @DisplayName("로또 당첨 테스트")
    @Test
    void USER_WINNER_NUMBER() {
        Lotto lotto = new Lotto(5);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        String[] winnerExpected = lottoNumbers.get(0).getLottoNumber().toString().split(",");

        assertThat(lotto.getRewardLotto(winnerExpected, 0).get(0))
                    .isEqualTo(new RewardStatus(6, false));
    }

    @DisplayName("로또 보너스 2등 테스트")
    @Test
    void USER_WINNER_WITH_BONUS_NUMBER() {
        Lotto lotto = new Lotto(1);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        String[] winnerExpected = lottoNumbers.get(0).getLottoNumber().toString().split(",");
        int bonus = Integer.parseInt(winnerExpected[0]);
        winnerExpected[0] = "0";
        assertThat(lotto.getRewardLotto(winnerExpected, bonus).get(0))
                    .isEqualTo(new RewardStatus(5, true));
    }






}

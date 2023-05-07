package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    WinningLotto winningLotto;
    Lotto myLotto, winningLottoExcludingBonus;
    LottoNumber bonusLottoNumber;

    @BeforeEach
    void setUp() {
        myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLottoExcludingBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        bonusLottoNumber = new LottoNumber(6);
        winningLotto = new WinningLotto(winningLottoExcludingBonus, bonusLottoNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "0:0"}, delimiter = ':')
    void 구입_매수_계산(long price, long lottoCount) {
        assertThat(LottoGame.lottoCount(price)).isEqualTo(lottoCount);
    }

    @Test
    void 총_수익률_계산() {
        //given
        List<Lotto> lottos = Arrays.asList(myLotto, myLotto);
        long purchasePrice = 2000l;

        //when
        LottoRewards reward = LottoGame.reward(lottos, winningLotto);

        //then
        assertThat(LottoGame.totalProfitRate(reward, purchasePrice)).isEqualTo(30000);
    }

    @Test
    void 일치_수별_횟수_세기() {
        //given
        List<Lotto> lottos = Arrays.asList(myLotto, winningLottoExcludingBonus);

        //when
        LottoRewards reward = LottoGame.reward(lottos, winningLotto);

        //then
        assertThat(reward.get(RewardType.FIVE_AND_BONUS).count()).isEqualTo(1);
        assertThat(reward.get(RewardType.SIX).count()).isEqualTo(1);
    }

    @Test
    void 당첨번호_5개_일치_보너스번호_일치() {
        //given
        List<Lotto> lottos = Arrays.asList(myLotto);

        //when
        LottoRewards reward = LottoGame.reward(lottos, winningLotto);

        //then
        assertThat(reward.get(RewardType.FIVE_AND_BONUS).count()).isEqualTo(1);
        assertThat(reward.get(RewardType.FIVE).count()).isEqualTo(0);
    }
}

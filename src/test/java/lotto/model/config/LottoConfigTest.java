package lotto.model.config;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoConfigTest {

    @Test
    void 상금조회_테스트(){
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoNumbers userNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(30), new LottoNumber(31)));


        LottoGame lottoGame = new LottoGame(winningNumbers);
        int rewardPrice = LottoConfig.winningRewards.get(lottoGame.howManyMatched(userNumbers));
        assertThat(rewardPrice).isEqualTo(50000);
    }
}
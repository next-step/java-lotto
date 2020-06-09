package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class LottoGameResultTest {

    @Test
    public void getResultTest() {
        //given
        int price = 1000;
        List<UserLotto> lottos = Arrays.asList(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        UserPrice userPrice = new UserPrice(price);
        int bonusNumber = 7;

        //when
        LottoGameResultDto lottoGameResultDto = new LottoGameResult()
            .getResult(lottos, new WinningLotto(winningNumbers, bonusNumber), userPrice);

        //then
        assertThat(lottoGameResultDto.getEarningRate()).isNotNull();
        assertThat(lottoGameResultDto.getEarningRate())
            .isEqualTo(Prize.FIRST.getCashPrize() / price);
        assertThat(lottoGameResultDto.getPrizeResult().get(Prize.FIRST.getGrade())).isEqualTo(1);
    }
}
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
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        UserPrice userPrice = new UserPrice(price);

        //when
        LottoGameResultDto lottoGameResultDto = new LottoGameResult()
            .getResult(lottos, winningLotto, userPrice);

        //then
        assertThat(lottoGameResultDto.getEarningRate()).isNotNull();
        assertThat(lottoGameResultDto.getEarningRate())
            .isEqualTo(Prize.FIRST.getCashPrize() / price);
        assertThat(lottoGameResultDto.getFirstPrizeCount()).isEqualTo(1);
    }
}
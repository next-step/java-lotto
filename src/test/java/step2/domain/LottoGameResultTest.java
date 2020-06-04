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
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        UserPrice userPrice = new UserPrice(price);
        LottoGameResult lottoGameResult =  new LottoGameResult(lottos, winningLotto, userPrice);

        //when
        LottoGameResultDto lottoGameResultDto = lottoGameResult.getResult();

        //then
        assertThat(lottoGameResultDto.getEarningRate()).isNotNull();
        assertThat(lottoGameResultDto.getEarningRate()).isEqualTo(Prize.FIRST.getCashPrize()/price);
        assertThat(lottoGameResultDto.getFirstPrizeCount()).isEqualTo(1);
    }
}
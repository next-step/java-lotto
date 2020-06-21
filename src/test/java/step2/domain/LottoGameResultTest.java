package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step2.util.Utils;


class LottoGameResultTest {

    @Test
    public void getResultTest() {
        //given
        int price = 1000;
        LottoSheet lottoSheet = new LottoSheet(
            Arrays.asList(new UserLotto(
                Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6)))));
        List<LottoNumber> winningNumbers = Utils
            .convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6));
        UserPrice userPrice = new UserPrice(price);
        int bonusNumber = 7;

        //when
        LottoGameResultDto lottoGameResultDto = new LottoGameResult()
            .getResult(lottoSheet, new WinningLotto(winningNumbers, new LottoNumber(bonusNumber)),
                userPrice);

        //then
        assertThat(lottoGameResultDto.getEarningRate()).isNotNull();
        assertThat(lottoGameResultDto.getEarningRate())
            .isEqualTo(Prize.FIRST.getCashPrize() / price);
        assertThat(lottoGameResultDto.getPrizeResult().get(Prize.FIRST)).isEqualTo(1);
    }
}
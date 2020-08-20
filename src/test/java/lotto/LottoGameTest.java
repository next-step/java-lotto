package lotto;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    public void lottoGameSuccess() {

        LottoGame lottoGame = new LottoGame(10000);
        lottoGame.setManualLottoCount(5);
        lottoGame.buyManual(Arrays.asList(
                new LottoNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6), 7))
        ));
        lottoGame.buyAuto();

        lottoGame.winning(new LottoResultNumber(
                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6), 7)));
    }

    @Test
    public void lottoGameFail() {

        LottoGame lottoGame = new LottoGame(10000);

        assertThatThrownBy(() ->
                lottoGame.winning(new LottoResultNumber(
                                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6), 7)))
        ).hasMessage(StringResources.ERR_NO_LOTTO_LIST);
    }
}

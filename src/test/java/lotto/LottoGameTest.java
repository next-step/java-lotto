package lotto;

import common.StringResources;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    public void lottoGameSuccess() {

        LottoGame lottoGame = new LottoGame(10000);
        lottoGame.buy();

        lottoGame.winning(new LottoResultNumber(
                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    public void lottoGameFail() {

        LottoGame lottoGame = new LottoGame(10000);

        assertThatThrownBy(() ->
                lottoGame.winning(new LottoResultNumber(
                                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))))
        ).hasMessage(StringResources.ERR_NO_LOTTO_LIST);
    }
}

package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {

    @Test
    public void lottoGameTest() {

        LottoResultNumber lottoResultNumber = new LottoResultNumber(
                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            lottoNumberList.add(new LottoNumber(new Ticket(
                    Arrays.asList(i, i + 1, i + 2, i + 3, i + 4, i + 5)
            )));
        }

        int money = 10000;

        LottoGame lottoGame = new LottoGame(money, lottoNumberList);
        lottoGame.buy();

        lottoGame.winning(lottoResultNumber);
    }
}

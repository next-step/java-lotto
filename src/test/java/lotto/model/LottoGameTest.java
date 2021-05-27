package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    void 매칭되는갯수_테스트(){
        LottoTicket winningNumbers = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoTicket userNumbers = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(30), new LottoNumber(31)));


        LottoGame lottoGame = new LottoGame(winningNumbers, userLottoTickets);
        int actual = lottoGame.howManyMatched(userNumbers);
        assertThat(actual).isEqualTo(4);
    }
}

package lotto.domain;

import lotto.service.LottoGame;
import lotto.view.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor() throws Exception {
        LottoGame lottoGame = new LottoGame(new Money(10000));
    }

    @DisplayName("입력금액에서 구매 가능한 로또만큼 구매 되는지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5"}, delimiter = ':')
    public void buyLotto(int myMoney, int expect) throws Exception {
        //given
        LottoGame lottoGame = new LottoGame(new Money(myMoney));

        //when
        LottoDto dto = lottoGame.play();

        //then
        assertThat(dto.getTickets().size()).isEqualTo(expect);
    }

//    @DisplayName("수익률 개산")
//    @Test
//    public void erning() throws Exception {
//        //given
//        List<Integer> lottoNumber1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        List<Integer> lottoNumber2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
//        LottoGame lottoGame = new LottoGame(Arrays.asList(new LottoTicket(lottoNumber1), new LottoTicket(lottoNumber2)));
//
//        //when
//        lottoGame.statisticAllGame(Arrays.asList(1, 2, 3, 10, 11, 12));
//        lottoGame.
//
//        //then
//    }
}

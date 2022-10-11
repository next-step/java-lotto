package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp(){
        lottoGame = LottoGame.newInstance();
    }

    @DisplayName("playLotto 구매 갯수 만큼의 로또 번호 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 9})
    void playLotto_make_purchaseCount_lottoNumber(int purchaseCount) {
        List<LottoNumber> lottoNumbers = lottoGame.playLotto(purchaseCount);
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("입력 받는 price 1000원 당 로또티켓 하나를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 5000, 6000, 9000})
    void lotto_ticket_price_is_1000(int price){
        int purchaseCount = lottoGame.makeLottoTicket(price);
        Assertions.assertThat(purchaseCount).isEqualTo(price / 1000);
    }
}
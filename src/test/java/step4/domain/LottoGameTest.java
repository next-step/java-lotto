package step4.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = LottoGame.newInstance();
    }

    @DisplayName("playLotto 인자 갯수 만큼의 로또 번호 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 50000, 6000, 9000})
    void playLotto_make_purchaseCount_lottoNumber(int price) {
        List<LottoNumbers> lottoNumbers = lottoGame.playLotto(Ticket.from(price));
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(price / 1000);
    }
}

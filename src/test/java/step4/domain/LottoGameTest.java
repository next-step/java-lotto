package step4.domain;

import java.util.Collections;
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

    @DisplayName("playLotto 의 로또 티켓 수만큼의 로또 번호 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void playLotto_make_purchaseCount_lottoNumber(int ticketCount) {
        List<LottoNumbers> lottoNumbers = lottoGame.playLotto(Ticket.from(ticketCount), Collections.emptyList());
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(ticketCount);
    }
}

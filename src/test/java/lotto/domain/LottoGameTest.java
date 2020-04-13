package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {

    @DisplayName("로또 자동 생성")
    @Test
    void autoGenerate() {
        Lotto lotto = LottoGame.autoGenerate();
        assertThat(lotto).isNotNull();
    }

    @DisplayName("금액에 맞게 로또 구매")
    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "3000, 3"})
    void buy(long money, int expectedSize) {
        List<Lotto> lottos = LottoGame.buy(money);
        assertThat(lottos.size()).isEqualTo(expectedSize);
    }

    @DisplayName("천원미만 구매 불가 에러")
    @Test
    void cantBuy() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoGame.buy(900));
    }

//    @DisplayName("구매한 로또와 당첨번호 비교")
//    @Test
//    void match() {
//        List<LottoNumber> lottoNumbers = Arrays.asList(
//                LottoNumber.of(1),
//                LottoNumber.of(2),
//                LottoNumber.of(3),
//                LottoNumber.of(4),
//                LottoNumber.of(5),
//                LottoNumber.of(6)
//        );
//
//        Lotto lotto = LottoGame.autoGenerate();
//        Lotto winningLotto = Lotto.of(lottoNumbers);
//
//        assertThat(LottoGame.match(lotto, winningLotto);
//    }
}
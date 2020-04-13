package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 자동 생성")
    @Test
    void autoGenerate() {
        Lotto lotto = LottoGame.autoGenerate();
        assertThat(lotto).isNotNull();
    }

    @DisplayName("천원으로 로또 1장 구매")
    @Test
    void buy() {
        List<Lotto> lottos = LottoGame.buy(1000);
        assertThat(lottos.size()).isEqualTo(1);
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
package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoMakerTest {

    private ManualLottoMaker manualLottoMaker = new ManualLottoMaker();

    @DisplayName("로또 번호를 담는 정수 리스트의 리스트를 받아서 Lottos 객체를 만들어 줍니다.")
    @Test
    void makeLottos() {
        // given
        List<List<Integer>> lottoNumbersList = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(11, 12, 13, 14, 15, 16)
        );
        // when
        Lottos lottos = manualLottoMaker.makeLottos(lottoNumbersList);
        // then
        assertThat(lottos).isEqualTo(new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        )));
    }

    @DisplayName("로또 번호를 담는 정수 리스트를 받아서 Lotto 객체를 만듭니다.")
    @Test
    void makeLotto() {
        // given
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        // when
        Lotto lotto = manualLottoMaker.makeLotto(lottoNumber);
        // then
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
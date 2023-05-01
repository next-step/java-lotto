package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private final LottoNumbers lottoNumbers = new LottoNumbers();

    @Test
    @DisplayName("Lotto 자동 발급 테스트")
    void autoLottoTest() {
        Lotto lotto = Lotto.from(lottoNumbers);
        assertThat(lotto.getLottoSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto 수동 발급 테스트")
    void manualLottoTest() {
        List<Integer> requestLotto = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(lottoNumbers, requestLotto);

        assertThat(lotto.getLottoSize()).isEqualTo(6);
    }


    @Test
    @DisplayName("당첨로또 번호와 매칭 수 테스트")
    void lottoTest() {

        List<Integer> givenWinnerLottoNumberList = List.of(1, 2, 3, 4, 5, 6);

        LottoNumbers winnerLottoNumbers = lottoNumbers.initializedManualLottoNumber(givenWinnerLottoNumberList);

        List<Integer> requestLotto = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(lottoNumbers, requestLotto);

        assertThat(lotto.countMatching(winnerLottoNumbers)).isEqualTo(6);
    }

}
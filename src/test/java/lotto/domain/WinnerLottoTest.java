package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerLottoTest {

    @Test
    @DisplayName("당첨 로또 발급  테스트")
    public void winnerLotto() {
        List<Integer> givenLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(new LottoNumberGroup(), givenLottoNumberList);

        List<LottoNumber> result = new ArrayList<>();

        for (Integer givenIndex : givenLottoNumberList) {
            result.add(LottoNumber.provideLottoNumber(givenIndex));
        }


        assertAll(
                () -> assertThat(winnerLotto.winnerLottoSize()).isEqualTo(6),
                () -> assertThat(winnerLotto).isEqualTo(new WinnerLotto(new LottoNumberGroup(result)))
        );

    }


    @Test
    @DisplayName("담청 로또와 발급한 로또 일치 테스트 ")
    public void winnerLottoCount() {
        List<Integer> givenWinnerLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(new LottoNumberGroup(), givenWinnerLottoNumberList);

        List<Integer> requestLottoNumberList = List.of(1, 2, 7, 8, 9, 10);
        Lotto lotto = Lotto.of(new LottoNumberGroup(), requestLottoNumberList);

        assertThat(winnerLotto.findMatchingCount(lotto)).isEqualTo(2);

    }
}
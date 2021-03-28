package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("우승 로또를 생성한다")
    @Test
    void winningLottoCreateTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        WinningLotto winningLotto = new WinningLotto(lottoNumberList, new LottoNumber(7));
        assertThat(winningLotto.numOfSize()).isEqualTo(6);
    }

    @DisplayName("우승 로또의 보너스 볼은 우승 번호와 일치하면 예외를 발생시킨다")
    @Test
    void winningLottoBonusExceptionTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        lottoNumberList.add(new LottoNumber(6));
        assertThatThrownBy(() -> new WinningLotto(lottoNumberList, lottoNumberList.get(6))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또와 비교해 결과를 반환한다")
    @Test
    void lottoIsWinTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        Lotto createdLotto = new Lotto(lottoNumberList);
        WinningLotto prizeLotto = new WinningLotto(lottoNumberList, new LottoNumber(7));
        assertThat(prizeLotto.howMatch(createdLotto)).isEqualTo(ResultMap.FIRST);
    }
}

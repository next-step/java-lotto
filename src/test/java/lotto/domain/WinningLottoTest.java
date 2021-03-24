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
        for (int i  = 1; i <= 7; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        WinningLotto winningLotto = new WinningLotto(lottoNumberList);
        assertThat(winningLotto.numOfSize()).isEqualTo(7);
    }

    @DisplayName("우승 로또는 7개 미만, 초과시 예외를 발생시킨다")
    @Test
    void winningLottoCreateExceptionTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i  = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        assertThatThrownBy(() ->new WinningLotto(lottoNumberList)).isInstanceOf(IllegalArgumentException.class);
        lottoNumberList.add(new LottoNumber(7));
        lottoNumberList.add(new LottoNumber(8));
        assertThatThrownBy(() ->new WinningLotto(lottoNumberList)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승 로또의 보너스 볼은 우승 번호와 일치하면 예외를 발생시킨다")
    @Test
    void winningLottoBonusExceptionTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i  = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        lottoNumberList.add(new LottoNumber(6));
        assertThatThrownBy(() ->new WinningLotto(lottoNumberList)).isInstanceOf(IllegalArgumentException.class);
    }
}

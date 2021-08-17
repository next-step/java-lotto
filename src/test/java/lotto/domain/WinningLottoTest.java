package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    public void init() {
        winningLotto = new WinningLotto();
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        winningLotto.compareLottoNumber(lottoNumber, 1);
        winningLotto.compareLottoNumber(lottoNumber, 2);
        winningLotto.compareLottoNumber(lottoNumber, 3);
        winningLotto.lottoPaperStatus();
    }

    @DisplayName("로또 번호 당첨 개수 확인 테스트")
    @Test
    public void lottoMatchTest() {
        assertThat(winningLotto.getLottoStatus()).isEqualTo(WinningLotto.FOURTH);
    }

    @DisplayName("로또 당첨 금액 테스트")
    @Test
    public void lottoEarnMoneyTest() {
        assertThat(winningLotto.getEarnMoney()).isEqualTo(WinningLotto.FOURTH_EARN_MONEY);
    }

}
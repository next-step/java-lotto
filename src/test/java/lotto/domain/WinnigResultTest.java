package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnigResultTest {

    WinnigResult winnigResult;

    @BeforeEach
    public void init() {
        winnigResult = new WinnigResult();
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        winnigResult.compareLottoNumber(lottoNumber, 1);
        winnigResult.compareLottoNumber(lottoNumber, 2);
        winnigResult.compareLottoNumber(lottoNumber, 3);
        winnigResult.updateLottoStatus();
    }

    @DisplayName("로또 번호 당첨 개수 확인 테스트")
    @Test
    public void lottoMatchTest() {
        assertThat(winnigResult.getLottoStatus()).isEqualTo(WinnigResult.FOURTH);
    }

    @DisplayName("로또 당첨 금액 테스트")
    @Test
    public void lottoEarnMoneyTest() {
        assertThat(winnigResult.getEarnMoney()).isEqualTo(WinnigResult.FOURTH_EARN_MONEY);
    }

}
package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnigResultTest {

    WinnigResult winnigResult;

    @BeforeEach
    public void init() {
        winnigResult = new WinnigResult();
    }

    @DisplayName("로또 당첨 번호 개수 테스트")
    @Test
    public void lottoMatchTest() {
        assertThat(winnigResult.getLottoStatus(WinnigResult.FIRST_MATCH)).
                isEqualTo(WinnigResult.FIRST);
    }

    @DisplayName("로또 당첨 번호 개수 테스트")
    @Test
    public void lottoEarnMoneyTest() {
        assertThat(winnigResult.getEarnMoney(WinnigResult.FIRST, 1)).
                isEqualTo(WinnigResult.FIRST_EARN_MONEY);
    }

}
package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoAutoGameTest {

    @ParameterizedTest
    @DisplayName("입력값 확인테스트")
    @ValueSource(ints = {0})
    public void validateInputTest(int input){
        assertThatThrownBy(() -> new BuyInfo(input,1999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총금액 / 게임당금액 = 총경기")
    public void getTotalGameTest() {
        ControlLottoGame controlLottoGame = new ControlLottoGame();
        int totalPrice = 14000;

        assertThat(controlLottoGame.startLotto(totalPrice).getBuyLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또기본정보테스트")
    public void setLottoNumberTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoList().size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또랜덤추출테스트")
    public void extractLottoNumberTest() {
        Lotto lotto = new Lotto();
        List<Integer> lottoRandom = lotto.extractLottoNumber();
        assertThat(lottoRandom.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨정보결과테스트")
    public void matchTest() {
        WinLotto winLotto = new WinLotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> buyLottoList = Arrays.asList(1,2,3,4,5,7);
        assertThat(winLotto.match(buyLottoList)).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨정보테스트")
    public void resultTest() {
        assertThat(WinInformation.matchWinInformation(3).getPrice()).isEqualTo(BigDecimal.valueOf(5000));
    }
}

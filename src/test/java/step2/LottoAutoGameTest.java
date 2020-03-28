package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.SetLottoGame;
import step2.view.BuyLotto;
import step2.view.Lotto;

import java.util.ArrayList;
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
        assertThatThrownBy(() -> new BuyLotto(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총금액 / 게임당금액 = 총경기")
    public void getTotalGameTest() {
        SetLottoGame setLottoGame = new SetLottoGame();
        int totalPrice = 14000;

        assertThat(setLottoGame.getTotalGame(totalPrice)).isEqualTo(14);
    }

    @Test
    @DisplayName("로또기본테스트")
    public void setLottoNumberTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumberList().size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또랜덤추출테스트")
    public void extractLottoNumberTest() {
        Lotto lotto = new Lotto();
        List<Integer> lottoRandom = SetLottoGame.extractLottoNumber(lotto.getLottoNumberList());
        System.out.println(lottoRandom);
        assertThat(lottoRandom.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨정보셋팅테스트")
    public void name() {
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);

        List<Integer> winLotto = new ArrayList<>();

      //  int cnt = SetLottoGame.resulit(winLotto, lotto);



    }

    @Test
    public void equalNumberTest() {
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);

        List<Integer> winLotto = new ArrayList<>();
        winLotto.add(1);
        winLotto.add(2);
        winLotto.add(3);
        winLotto.add(7);
        winLotto.add(8);
        winLotto.add(9);

        //int count = SetLottoGame(lotto, winLotto);

        //assertThat(count).isEqualTo(3);
    }
}

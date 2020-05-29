package lotto_step2;

import lotto_step2.domain.LottoGame;
import lotto_step2.model.Lotto;
import lotto_step2.model.Lottos;
import lotto_step2.model.Prize;
import lotto_step2.model.PrizeMachine;
import lotto_step2.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    private InputView inputView = new InputView();
    private Lotto lotto;
    private LottoGame lottoGame;

    @BeforeEach
    void init(){
        List<Integer> lastWeekLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(lastWeekLotto);
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("입력 번호 입력오류")
    public void inputLottoNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.checkSplitValue(55);
        });
    }

    @Test
    @DisplayName("구매금액 1000원 이하")
    public void inputMoneyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.checkMoney(100);
        });
    }

    @Test
    @DisplayName("지난 주 당첨 번호개수가 6개가 아님")
    public void inputSplitValuesTest() {
        List<Integer> intSplitValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.checkIntSplitValues(Collections.singletonList(intSplitValues.size()));
        });
    }

    @Test
    @DisplayName("구매금액으로 로또구매")
    public void buyLosttsTest() {
        Lottos lottos = new Lottos(10500);
        assertThat(lottos.getLottos()).hasSize(10);
    }

    @DisplayName("4등 테스트 - 번호 3개 일치")
    @Test
    void fourthPrizeTest() {
        Lottos myLotto = new Lottos(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)));
        List<Prize> results = lottoGame.matches(lotto, myLotto);
        assertThat(results.get(0).getPrize()).isEqualTo(PrizeMachine.FOURTH);
    }

    @DisplayName("3등 테스트 - 번호 4개 일치")
    @Test
    void thirdPrizeTest() {
        Lottos myLotto = new Lottos(new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)));
        List<Prize> results = lottoGame.matches(lotto, myLotto);
        assertThat(results.get(0).getPrize()).isEqualTo(PrizeMachine.THIRD);
    }

    @DisplayName("2등 테스트 - 번호 5개 일치")
    @Test
    void secondPrizeTest() {
        Lottos myLotto = new Lottos(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)));
        List<Prize> results = lottoGame.matches(lotto, myLotto);
        assertThat(results.get(0).getPrize()).isEqualTo(PrizeMachine.SECOND);
    }

    @DisplayName("1등 테스트 - 번호 6개 일치")
    @Test
    void firstPrizeTest() {
        Lottos myLotto = new Lottos(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Prize> results = lottoGame.matches(lotto, myLotto);
        assertThat(results.get(0).getPrize()).isEqualTo(PrizeMachine.FIRST);
    }

    @DisplayName("0개 일치")
    @Test
    void zeroPrizeTest() {
        Lottos myLotto = new Lottos(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
        List<Prize> results = lottoGame.matches(lotto, myLotto);
        assertThat(results.get(0).getPrize()).isEqualTo(PrizeMachine.ZERO);
    }
}

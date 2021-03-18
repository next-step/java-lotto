package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    InputView inputView;
    Lotto lotto;
    LottoMachine lottoMachine;

    @BeforeEach
    public void setup(){
        inputView = new InputView();
        lotto = new Lotto();
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("입력 받은 금액 정합성 체크")
    public void inputMoneyNormal(){
        assertTrue(inputView.normal(15000));
        assertFalse(inputView.normal(15999));
        assertFalse(inputView.normal(-1000));
    }

    @Test
    @DisplayName("입력 받은 금액 / 1000 만큼 구매")
    public void buyLottoCount(){
        assertEquals(lotto.buyCount(15000), 15);
    }

    @Test
    @DisplayName("자동 구매 로또 번호 범위는 0 ~ 45")
    public void authLottoArrange(){
        assertTrue(lottoMachine.lottoNumbers(1).get(0).normal());
    }

    @Test
    @DisplayName("중복 번호 없는 자동 구매")
    public void lottoNumberDuplicate(){
        assertTrue(lottoMachine.lottoNumbers(1).get(0).normalSize());
    }

}

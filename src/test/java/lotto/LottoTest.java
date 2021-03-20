package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

//    InputView inputView;
    Lotto lotto;
    LottoResult lottoResult;
    LottoMachine lottoMachine;
    LottoNumbers winningNumbers;
    List<LottoNumbers> buyLottoNumbers;

    @BeforeEach
    public void setup(){
//        inputView = new InputView();
        lotto = new Lotto();
        lottoResult = new LottoResult();
        lottoMachine = new LottoMachine();
        winningNumbers = new LottoNumbers("1,2,3,4,5,6");
        buyLottoNumbers = new ArrayList<>();
    }

//    @Test
//    @DisplayName("입력 받은 금액 정합성 체크")
//    public void inputMoneyNormal(){
//        assertTrue(inputView.normal(15000));
//        assertFalse(inputView.normal(15999));
//        assertFalse(inputView.normal(-1000));
//    }
//
//    @Test
//    @DisplayName("입력 받은 금액 / 1000 만큼 구매")
//    public void buyLottoCount(){
//        assertEquals(inputView.count(15000), 15);
//    }

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

    @Test
    @DisplayName("번호가 1 ~ 45가 아닐 경우")
    public void lottoNumberValid(){
        assertThatIllegalArgumentException().isThrownBy (
                () -> new LottoNumbers("1,2,3,4,5,50")
        );
    }

    @Test
    @DisplayName("번호 6개 아닐 경우")
    public void lottoNumberCountValid(){
        assertThatIllegalArgumentException().isThrownBy (
                () -> new LottoNumbers("1,2,3,4,5")
        );
    }

    @Test
    @DisplayName("4등 결과 확인")
    public void fourthRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,10,20,30"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("3개 일치 (5000원)- 1개");
        assertThat(result).contains("총 수익률은 5.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("3등 결과 확인")
    public void thirdRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,10,20"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("4개 일치 (50000원)- 1개");
        assertThat(result).contains("총 수익률은 50.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("2등 결과 확인")
    public void secondRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,10"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("5개 일치 (1500000원)- 1개");
        assertThat(result).contains("총 수익률은 1500.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("1등 결과 확인")
    public void firstRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("6개 일치 (2000000000원)- 1개");
        assertThat(result).contains("총 수익률은 2000000.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @ParameterizedTest
    @CsvSource(value = {"1f:본전이","0.5f:손해", "1.5f:이득이"}, delimiter = ':')
    @DisplayName("수익률 별 메시지")
    public void resultMessage(float rateOfReturn, String message){
        assertThat(LottoResultMessage.message(rateOfReturn)).isEqualTo(message);
    }

}

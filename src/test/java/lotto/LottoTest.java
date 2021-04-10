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

    Lotto lotto;
    LottoResult lottoResult;
    LottoMachine lottoMachine;
    WinningNumbers winningNumbers;
    List<LottoNumbers> buyLottoNumbers;

    @BeforeEach
    public void setup(){
        lotto = new Lotto();
        lottoResult = new LottoResult();
        lottoMachine = new LottoMachine();
        winningNumbers = new WinningNumbers("1,2,3,4,5,6", LottoNumber.lottoNumber(7));
        buyLottoNumbers = new ArrayList<>();
    }

    @Test
    @DisplayName("입력 받은 금액 / 1000 만큼 구매")
    public void buyLottoCount(){
        assertEquals(lottoMachine.buyCount(15000), 15);
    }

    @Test
    @DisplayName("전체 구매 개수보다 수동 구매 개수가 클 경우")
    public void manualLottoCountValid(){
        assertThatIllegalArgumentException().isThrownBy (
                () -> lottoMachine.buyCountValid(10, 15)
        );
    }

    @Test
    @DisplayName("범위를 벗어나는 로또 번호")
    public void lottoNumberValid(){
        assertThatIllegalArgumentException().isThrownBy (
                () -> new LottoNumbers("1,2,3,4,5,55")
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
    @DisplayName("5등 결과 확인")
    public void fifthRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,10,20,30"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("3개 일치 (5000원)- 1개");
        assertThat(result).contains("총 수익률은 5.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("4등 결과 확인")
    public void fourthRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,10,20"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("4개 일치 (50000원)- 1개");
        assertThat(result).contains("총 수익률은 50.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("3등 결과 확인")
    public void thirdRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,10"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("5개 일치 (1500000원)- 1개");
        assertThat(result).contains("총 수익률은 1500.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }

    @Test
    @DisplayName("2등 결과 확인")
    public void secondRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,7"));
        String result = lottoResult.result(buyLottoNumbers, winningNumbers);
        assertThat(result).contains("5개 일치, 보너스 볼 일치 (30000000원)- 1개");
        assertThat(result).contains("총 수익률은 30000.00입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임");
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


    @Test
    @DisplayName("보너스 볼 체크")
    public void bonusBall() {
        assertTrue(lottoMachine.useAbleBonusBall("1,2,3,4,5,6", 30));
        assertFalse(lottoMachine.useAbleBonusBall("1,2,3,4,5,6", 5));
    }

}

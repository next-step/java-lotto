package lotto;

import lotto.model.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.view.LottoResultMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineResultTest {
    LottoMachine lottoMachine;
    LottoResult lottoResult;
    LottoNumbers winningNumbers;
    List<LottoNumbers> buyLottoNumbers;

    @BeforeEach
    public void setup(){
        lottoMachine = new LottoMachine();
        lottoResult = new LottoResult();
        winningNumbers = new LottoNumbers("1,2,3,4,5,6");
        buyLottoNumbers = new ArrayList<>();
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

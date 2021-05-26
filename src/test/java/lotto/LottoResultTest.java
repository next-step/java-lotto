package lotto;

import lotto.model.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.LottoRanking;
import lotto.model.LottoResult;
import lotto.view.LottoResultMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
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
        Map<LottoRanking, Integer> result = lottoResult.lottoResult(buyLottoNumbers, winningNumbers);
        assertThat(result.get(LottoRanking.FIFTH).equals(1)).isTrue();
    }

    @Test
    @DisplayName("4등 결과 확인")
    public void fourthRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,10,20"));
        Map<LottoRanking, Integer> result = lottoResult.lottoResult(buyLottoNumbers, winningNumbers);
        assertThat(result.get(LottoRanking.FOURTH).equals(1)).isTrue();

    }

    @Test
    @DisplayName("3등 결과 확인")
    public void thirdRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,10"));
        Map<LottoRanking, Integer> result = lottoResult.lottoResult(buyLottoNumbers, winningNumbers);
        assertThat(result.get(LottoRanking.THIRD).equals(1)).isTrue();
    }


    @Test
    @DisplayName("1등 결과 확인")
    public void firstRanking() {
        buyLottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
        Map<LottoRanking, Integer> result = lottoResult.lottoResult(buyLottoNumbers, winningNumbers);
        assertThat(result.get(LottoRanking.FIRST).equals(1)).isTrue();

    }

    @ParameterizedTest
    @CsvSource(value = {"1f:본전이","0.5f:손해", "1.5f:이득이"}, delimiter = ':')
    @DisplayName("수익률 별 메시지")
    public void resultMessage(float rateOfReturn, String message){
        assertThat(LottoResultMessage.message(rateOfReturn)).isEqualTo(message);
    }

}

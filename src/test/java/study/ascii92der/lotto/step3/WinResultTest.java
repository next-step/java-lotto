package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinResultTest {

    @Test
    @DisplayName("3개 일치 값 저장")
    void saveMatchLottoNumberThreeTest() {
        WinResult winResult = new WinResult();

        winResult.saveWinResult(LottoWinner.FOURTH);
        winResult.saveWinResult(LottoWinner.FOURTH);
        winResult.saveWinResult(LottoWinner.FOURTH);

        assertThat(winResult.result(LottoWinner.FOURTH)).isEqualTo(3);
    }

    @Test
    @DisplayName("4개 일치 값 저장")
    void saveMatchLottoNumberFourTest() {
        WinResult winResult = new WinResult();

        winResult.saveWinResult(LottoWinner.THIRD);
        winResult.saveWinResult(LottoWinner.THIRD);

        assertThat(winResult.result(LottoWinner.THIRD)).isEqualTo(2);
    }

    @Test
    @DisplayName("5개 일치 값 저장")
    void saveMatchLottoNumberFiveTest() {
        WinResult winResult = new WinResult();

        winResult.saveWinResult(LottoWinner.SECOND);
        winResult.saveWinResult(LottoWinner.SECOND);
        winResult.saveWinResult(LottoWinner.SECOND);
        winResult.saveWinResult(LottoWinner.SECOND);
        winResult.saveWinResult(LottoWinner.SECOND);

        assertThat(winResult.result(LottoWinner.SECOND)).isEqualTo(5);
    }

    @Test
    @DisplayName("6개 일치 값 저장")
    void saveMatchLottoNumberSixTest() {
        WinResult winResult = new WinResult();

        winResult.saveWinResult(LottoWinner.FIRST);

        assertThat(winResult.result(LottoWinner.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치되는 로또 번호 계산 테스트")
    void calculateMatchedNumberCountTest() {
        String lottoString = "1,2,3,4,5,11";
        LottoResult lottoResult = new LottoResult(new Lotto(lottoString), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(lottoResult);
        WinResult winResult = new WinResult(lottoResults);

        assertThat(winResult.result(LottoWinner.SECOND)).isEqualTo(1);
    }
}

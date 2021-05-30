package study.ascii92der.lotto.step3n4;

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
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,11,22,33"),
                new Lotto("1,2,3,12,21,44")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.result(LottoWinner.FOURTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("4개 일치 값 저장")
    void saveMatchLottoNumberFourTest() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,4,22,33"),
                new Lotto("1,2,3,11,6,33"),
                new Lotto("6,2,3,11,5,33")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.result(LottoWinner.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 일치 값 저장")
    void saveMatchLottoNumberFiveTest() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,4,5,33"),
                new Lotto("1,2,6,4,5,33")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.result(LottoWinner.SECOND)).isEqualTo(2);
    }

    @Test
    @DisplayName("6개 일치 값 저장")
    void saveMatchLottoNumberSixTest() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,4,5,6")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.result(LottoWinner.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치되는 로또 번호 계산 테스트")
    void calculateMatchedNumberCountTest() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,4,5,33")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.result(LottoWinner.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률 계산")
    void calculateTotalEarningRate() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto("1,2,3,4,5,33"), new Lotto("1,2,3,16,17,18")));
        WinResult winResult = new WinResult(lottos, new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))));

        assertThat(winResult.totalEarningRate()).isEqualTo(752.5);
    }
}

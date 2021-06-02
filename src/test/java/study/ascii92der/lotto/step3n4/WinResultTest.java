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
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 22, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 12, 21, 44));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.result(LottoWinner.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("4개 일치 값 저장")
    void saveMatchLottoNumberFourTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 22, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 6, 33));
        List<Integer> lottoNumbers3 = new ArrayList<>(Arrays.asList(6, 2, 3, 11, 5, 33));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2), new Lotto(lottoNumbers3)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.result(LottoWinner.FOURTH)).isEqualTo(3);
    }

    @Test
    @DisplayName("5개 일치 값 저장")
    void saveMatchLottoNumberFiveTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 6, 4, 5, 33));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.result(LottoWinner.THIRD)).isEqualTo(2);
    }

    @Test
    @DisplayName("6개 일치 값 저장")
    void saveMatchLottoNumberSixTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.result(LottoWinner.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치되는 로또 번호 계산 테스트")
    void calculateMatchedNumberCountTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.result(LottoWinner.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률 계산")
    void calculateTotalEarningRate() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 41, 16, 17, 18));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2)));
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), 45);

        assertThat(winResult.totalEarningRate()).isEqualTo(750.0);
    }

    @Test
    @DisplayName("보너스 숫자를 포함한 총 수익률 계산")
    void calculateTotalEarningRateWithBonus() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 41, 16, 17, 18));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2)));
        int bonusNumber = 33;
        WinResult winResult = new WinResult(lottos,
                new ArrayList<>(Arrays.asList("1,2,3,4,5,6".split(","))), bonusNumber);

        assertThat(winResult.totalEarningRate()).isEqualTo(15000.0);
    }
}

package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {

    @Test
    @DisplayName("1~45개 숫자를 가지는 로또 기계 생성 테스트")
    void lottoMachine() {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 1; i <= 45; i++) {
            assertThat(lottoMachine.createLottoMachine()).contains(i);
        }
    }

    @Test
    @DisplayName("6개 번호를 랜덤으로 추출 테스트")
    void lottoRandomNumber() {
        LottoMachine lottoMachine = new LottoMachine();
        List <Integer> lottoNum = lottoMachine.autoLottoNumber();
        assertThat(lottoNum.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 당첨번호와 3개일치 테스트")
    void lottoWinning() {
        String LastWeekWinnerNumber = "1,2,3,13,35,42";
        List <Integer> lottoNumber = Arrays.asList(new Integer[]{6, 13, 23, 29, 35, 42});
        Lotto lotto = new Lotto(lottoNumber);
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(3);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount()).price()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력한 당첨번호와 6개일치 테스트")
    void lottoWinningAll() {
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        List <Integer> lottoNumber = Arrays.asList(new Integer[]{6, 13, 23, 29, 35, 42});
        Lotto lotto = new Lotto(lottoNumber);
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(6);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount()).price()).isEqualTo(20000000);
    }

    @Test
    @DisplayName("총 수익룰 계산 기능 구현")
    void lottoRateOfReturn() {
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        Integer[][] testLottoSet = {
                {6, 13, 23, 30, 36, 43},
                {1, 5, 7, 8, 9, 19},
                {22, 23, 34, 35, 36, 45}
        };
        List <Lotto> lottos = new ArrayList <>();
        for (Integer[] tempLottos : testLottoSet) {
            List <Integer> lottoNumber = Arrays.asList(tempLottos);
            Lotto lotto = new Lotto(lottoNumber);
            lotto.winnerCheck(LastWeekWinnerNumber);
            lottos.add(lotto);
        }
        LottoGames lottoGames = new LottoGames(lottos);
        assertThat(lottoGames.rateOfReturn()).isEqualTo(1.66);
    }

}

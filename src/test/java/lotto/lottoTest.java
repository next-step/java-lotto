package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {

    @Test
    @DisplayName("1~45개 숫자를 가지는 로또 기계 생성 테스트")
    void lottoMachine() {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 1; i <= 45; i++){
            assertThat(lottoMachine.lottoNumbers).contains(i);
        }
    }

    @Test
    @DisplayName("6개 번호를 랜덤으로 추출 테스트")
    void lottoRandomNumber(){
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNum = lottoMachine.getGameNumber();
        assertThat(lottoNum.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 당첨번호와 3개일치 테스트")
    void lottoWinning(){
        String LastWeekWinnerNumber = "1,2,3,13,35,42";
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{6,13,23,29,35,42});
        Lotto lotto = new Lotto(lottoNumber);
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(3);
        assertThat(lotto.getWinnerPrice()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력한 당첨번호와 6개일치 테스트")
    void lottoWinningAll(){
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{6,13,23,29,35,42});
        Lotto lotto = new Lotto(lottoNumber);
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(6);
        assertThat(lotto.getWinnerPrice()).isEqualTo(20000000);
    }

    @Test
    @DisplayName("당청에 따른 결과를 반환하는 기능 테스트")
    void lottoWinnerResult(){
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        String resultText = "6개 일치 20000000";
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{6,13,23,29,35,42});
        Lotto lotto = new Lotto(lottoNumber);
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getResultText()).isEqualTo(resultText);
    }

}

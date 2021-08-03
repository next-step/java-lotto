package lotto;

import lotto.application.CreateShffledLottoNumbers;
import lotto.application.PlayLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    PlayLotto playLotto = new PlayLotto();
    Lotto winningLotto;

    @BeforeEach
    void setup(){
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);
        winningLotto = new Lotto(winningLottoNumbers);
    }
    @Test
    @DisplayName("금액에 따른 로또 생성")
    void lottoCountTest(){
        int cash = 14000;
        int lottoCount = PlayLotto.calculateLottoCount(cash);
        List<Lotto> lottos = playLotto.createLotto(lottoCount);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 생성")
    void createLottoTest(){
        Lotto lotto = new Lotto(new CreateShffledLottoNumbers());
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호 로또 생성")
    void createWinningLottoTest(){
        assertThat(winningLotto.getLottoNumbers()).contains(1,2,3,4,5,6);
    }

    // 배열로 넘기는 테스트를 찾지 못해서 이렇게 6개의 매개변수 테스트를 진행했는데 배열로 넘기는 방법이 있나요??
    @ParameterizedTest
    @CsvSource({"1,2,3,9,10,11,4","1,2,3,4,9,10,3","1,2,3,4,5,9,2","1,2,3,4,5,6,1","9,10,11,12,13,14,0"})
    @DisplayName("등수 확인")
    void fourthTest(int number1, int number2, int number3, int number4, int number5, int number6, int testPrizeNumber){
        List<Integer> lottoNumberList = Arrays.asList(number1,number2,number3,number4,number5,number6);
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        Lotto lotto = new Lotto(lottoNumbers);
        int prizeNumber = winningLotto.checkWinning(lotto);
        assertThat(prizeNumber).isEqualTo(testPrizeNumber);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,9,10,11,4","1,2,3,4,9,10,3","1,2,3,4,5,9,2","1,2,3,4,5,6,1","9,10,11,12,13,14,0"})
    @DisplayName("로또게임")
    void playLottoTest(int number1, int number2, int number3, int number4, int number5, int number6, int testPrizeNumber){
        String winningNumberString = "1,2,3,4,5,6";
        List<Integer> lottoNumberList = Arrays.asList(number1,number2,number3,number4,number5,number6);
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        Lotto lotto = new Lotto(lottoNumbers);
        int[] winningArray = PlayLotto.playLotto(winningNumberString, Arrays.asList(lotto));
        assertThat(winningArray[testPrizeNumber]).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"10,0,1,0,2,107.86","13,1,0,0,0,14285.71","12,0,0,0,2,0.71"})
    @DisplayName("수익률 계산")
    void profitTest(int none, int firstCount, int secondCount, int thirdCound, int fourthCount, double testProfit){
        int cash = 14000;
        int[] prizeArray = new int[]{none, firstCount, secondCount, thirdCound, fourthCount};
        double profit = PlayLotto.calculateProfitRate(cash,prizeArray);
        assertThat(profit).isEqualTo(testProfit);
    }


    @Test
    @DisplayName("보너스 볼 추가")
    void bonusNumber() {
        String bonusNumberString = "45";
        BonusNumber bonusNumber = new BonusNumber(bonusNumberString);
    }
}

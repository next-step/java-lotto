package step2.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Util;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.NormalLotto;
import step2.domain.lotto.WinningLotto;
import step2.dto.JudgeResponseDTO;

import java.util.ArrayList;
import java.util.List;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        this.judge = new Judge();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 : 11,12,13,14,15,16: 17 : 0,0,0,0,0",
            "1,2,3,4,5,6 : 1,2,3,14,15,16   : 17 : 1,0,0,0,0",
            "1,2,3,4,5,6 : 1,2,3,4,15,16    : 17 : 0,1,0,0,0",
            "1,2,3,4,5,6 : 1,2,3,4,5,16     : 17 : 0,0,1,0,0",
            "1,2,3,4,5,17: 1,2,3,4,5,16     : 17 : 0,0,0,1,0",
            "1,2,3,4,5,6 : 1,2,3,4,5,6      : 17 : 0,0,0,0,1"}, delimiter = ':')
    @DisplayName("판정 결과를 정확하게 받아올 수 있다")
    void canCalculateResult(String normalLottoString, String winningLottoString, int bonusNumber, String expected) {
        List<Integer> expectedIntegers = Util.integerList(expected);
        JudgeResponseDTO judgeResponse = judgeResponse(normalLottoString, winningLottoString, bonusNumber);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(judgeResponse.getFifthPriceCount()).isEqualTo(expectedIntegers.get(0));
        softAssertions.assertThat(judgeResponse.getForthPriceCount()).isEqualTo(expectedIntegers.get(1));
        softAssertions.assertThat(judgeResponse.getThirdPriceCount()).isEqualTo(expectedIntegers.get(2));
        softAssertions.assertThat(judgeResponse.getSecondPriceCount()).isEqualTo(expectedIntegers.get(3));
        softAssertions.assertThat(judgeResponse.getFirstPriceCount()).isEqualTo(expectedIntegers.get(4));
        softAssertions.assertAll();
    }

    private JudgeResponseDTO judgeResponse(String normalLottoString, String winningLottoString, int bonusNumber) {
        NormalLotto normalLotto = new NormalLotto(normalLottoString);
        List<NormalLotto> normalLottoList = new ArrayList<>();
        normalLottoList.add(normalLotto);
        LottoList lottoList = new LottoList(normalLottoList);
        WinningLotto winningLotto = new WinningLotto(winningLottoString, bonusNumber);
        return judge.calculateResult(lottoList, winningLotto);
    }

}

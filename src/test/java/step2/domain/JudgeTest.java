package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Util;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoMachine;
import step2.domain.lotto.NormalLotto;
import step2.domain.lotto.WinningLotto;
import step2.domain.price.PriceList;
import step2.dto.JudgeResponseDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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
        NormalLotto normalLotto = new NormalLotto(normalLottoString);
        List<NormalLotto> normalLottoList = new ArrayList<>();
        normalLottoList.add(normalLotto);
        LottoList lottoList = new LottoList(normalLottoList);
        WinningLotto winningLotto = new WinningLotto(winningLottoString, bonusNumber);
        List<Integer> expectedIntegers = Util.integerList(expected);
        JudgeResponseDTO judgeResponseDTO = judge.calculateResult(lottoList, winningLotto);
        assertThat(judgeResponseDTO.getFifthPriceCount()).isEqualTo(expectedIntegers.get(0));
        assertThat(judgeResponseDTO.getForthPriceCount()).isEqualTo(expectedIntegers.get(1));
        assertThat(judgeResponseDTO.getThirdPriceCount()).isEqualTo(expectedIntegers.get(2));
        assertThat(judgeResponseDTO.getSecondPriceCount()).isEqualTo(expectedIntegers.get(3));
        assertThat(judgeResponseDTO.getFirstPriceCount()).isEqualTo(expectedIntegers.get(4));
    }

}

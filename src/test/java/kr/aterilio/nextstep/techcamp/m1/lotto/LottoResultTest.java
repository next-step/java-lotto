package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.JUnitParser;
import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 번호와 보너스 볼 일치 갯수에 따라 당첨금이 정해진다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6+7:2000000000",
            "1,2,3,4,5,6:1,2,3,4,5,7+6:30000000",
            "1,2,3,4,5,6:1,2,3,4,5,7+8:1500000",
            "1,2,3,4,5,6:1,2,3,4,7,8+9:50000",
            "1,2,3,4,5,6:1,2,3,7,8,9+10:5000",
            "1,2,3,4,5,6:1,2,7,8,9,10+11:0",
    }, delimiter = ':')
    public void judgePrizeMoney(String inputLottoNumbers, String inputLuckyNumbers, int expected) {
        Lotto lotto = new Lotto(LottoParser.parse(inputLottoNumbers));
        List<Lotto> lottoList = Collections.singletonList(lotto);
        LottoBundle lottoBundle = new LottoBundle(lottoList);

        LuckyNumbers luckyNumbers = JUnitParser.parseLuckyNumber(inputLuckyNumbers);

        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundle);
        assertThat(lottoResult.prizeMoney()).isEqualTo(expected);
    }
}

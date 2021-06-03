package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;
import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 번호와 주어진 로또의 일치하는 갯수에 따른 당첨금을 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:2000000000",
            "1,2,3,4,5,6:1,2,3,4,5,7:1500000",
            "1,2,3,4,5,6:1,2,3,4,7,8:50000",
            "1,2,3,4,5,6:1,2,3,7,8,9:5000",
            "1,2,3,4,5,6:1,2,7,8,9,10:0",
    }, delimiter = ':')
    public void judgePrizeMoney(String luckyNumber, String lottoBundle, int expected) {
        LottoResult lottoResult = new LottoResult(
                new LuckyNumbers(luckyNumber), parseLottoBundles(lottoBundle)
        );
        assertThat(lottoResult.prizeMoney()).isEqualTo(expected);
    }

    @DisplayName("각 일치 갯수에 따른 당첨 횟수를 누적으로 표기한다.")
    @ParameterizedTest
    @CsvSource(value = {
            //expected = 1ST:2ND:3RD:4TH (count)
            "1,2,3,4,5,6|1,2,3,4,5,6|1:0:0:0",
            "1,2,3,4,5,6|1,2,3,4,5,7|0:1:0:0",
            "1,2,3,4,5,6|1,2,3,4,7,8|0:0:1:0",
            "1,2,3,4,5,6|1,2,3,7,8,9|0:0:0:1",
            "1,2,3,4,5,6|1,2,7,8,9,10|0:0:0:0",
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,7,8,9,10|1:1:1:1",
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,3,7,8,9|1:1:1:2",
    }, delimiter = '|')
    public void resultCount(String luckyNumber, String lottoBundle, String expected) {
        LottoResult lottoResult = new LottoResult(
                new LuckyNumbers(luckyNumber), parseLottoBundles(lottoBundle)
        );
        Integer[] expectedCount = parseExpected(expected);

        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_6)).isEqualTo(expectedCount[0]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_5)).isEqualTo(expectedCount[1]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_4)).isEqualTo(expectedCount[2]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_3)).isEqualTo(expectedCount[3]);
    }

    private Integer[] parseExpected(String expected) {
        return StringUtil.convertToIntegerArray(
                expected.split(":")
        );
    }


    private static final int UNIT_POINT_POSITION = 2;

    private static final String SPEC_TEST_CASE = "8,21,23,41,42,43" + ":" +
                                                "3,5,11,16,32,38" + ":" +
                                                "7,11,16,35,36,44" + ":" +
                                                "1,8,11,31,41,42" + ":" +
                                                "13,14,16,38,42,45" + ":" +
                                                "7,11,30,40,42,43" + ":" +
                                                "2,13,22,32,38,45" + ":" +
                                                "23,25,33,36,39,41" + ":" +
                                                "1,3,5,14,22,45" + ":" +
                                                "5,9,38,41,43,44" + ":" +
                                                "2,8,9,18,19,21" + ":" +
                                                "13,14,18,21,23,35" + ":" +
                                                "17,21,29,37,42,45" + ":" +
                                                "3,8,27,30,35,44";

    @DisplayName("당첨 결과 판정 후 당첨 통계 수익률을 표기한다.")
    @ParameterizedTest
    @CsvSource(value = {
            // 2_000_000_000 / 1_000 = 2_000_000
            "1,2,3,4,5,6|1,2,3,4,5,6|2000000.00",
            // 1_500_000 / 1_000 = 1_500
            "1,2,3,4,5,6|1,2,3,4,5,7|1500.00",
            // 50_000 / 1_000 = 50
            "1,2,3,4,5,6|1,2,3,4,7,8|50.00",
            // 5_000 / 1_000 = 5
            "1,2,3,4,5,6|1,2,3,7,8,9|5.00",
            // 0 / 1_000 = 0
            "1,2,3,4,5,6|1,2,7,8,9,10|0.00",
            // 2_001_555_000 / 5_000 = 400_311
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,7,8,9,10|400311.00",
            // 2_001_560_000 / 5_000 = 400_312
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,3,7,8,9|400312.00",
            // / 5_000 / 14_000
            "1,2,3,4,5,6|" + SPEC_TEST_CASE + "|0.35",
    }, delimiter = '|')
    public void rateOfReturn(String luckyNumber, String lottoBundle, String expected) {
        LottoResult lottoResult = new LottoResult(
                new LuckyNumbers(luckyNumber), parseLottoBundles(lottoBundle)
        );

        String expectedRate = StringUtil.floorFloatWithPointPosition(
                lottoResult.rateOfReturn(), UNIT_POINT_POSITION
        );

        assertThat(expectedRate).isEqualTo(expected);
    }

    private LottoBundle parseLottoBundles(String lottoBundle) {
        String[] lottoArray = lottoBundle.split(":");
        List<Lotto> lottoList = new ArrayList<>();
        for(String lotto : lottoArray) {
            lottoList.add(new Lotto(LottoParser.parse(lotto)));
        }
        return new LottoBundle(lottoList);
    }
}

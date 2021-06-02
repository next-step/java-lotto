package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;
import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 구입 금액을 입력받으면 로또를 구매한다. (1000원당 1장)")
    @ParameterizedTest
    @CsvSource(value = {"3000,3", "14000,14", "8000,8"})
    public void buyLotto(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -5000, -100})
    public void buyLottoFailed(int money) {
        assertThatThrownBy(() -> {
            new LottoBundle(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 이상");
    }

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_outOfRange() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{-1, 2, 3, 4, 5, 46});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("로또 생성 시 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_duplicated() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{1, 2, 3, 4, 5, 1});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("입력받는 당첨 번호는 쉼표(,)로 분리되는 숫자의 나열이며 공백은 무시한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "5, 2, 3, 1, 6, 7:6"}, delimiter = ':')
    public void createLuckyNumbers(String inputLuckyNumbers, int count) {
        LuckyNumbers luckyNumbers = new LuckyNumbers(inputLuckyNumbers);
        assertThat(luckyNumbers.count()).isEqualTo(count);
    }

    @DisplayName("입력받는 당첨 번호의 갯수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,2,1", "5, 2, 3"})
    public void createLuckyNumbersFailed_count(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,t,1", "5, t, 3"})
    public void createLuckyNumbersFailed_notInteger(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @DisplayName("당첨 번호에 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "-1,2,3,4,5,6"})
    public void createLuckyNumbersFailed_outOfRange(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1", "6,2,3,4,5,6"})
    public void createLuckyNumbersFailed_duplicated(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호와 주어진 로또의 일치하는 갯수를 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:6",
            "1,2,3,4,5,6:1,2,3,4,5,7:5",
            "1,2,3,4,5,6:1,2,3,4,7,8:4",
            "1,2,3,4,5,6:1,2,3,7,8,9:3",
            "1,2,3,4,5,6:1,2,7,8,9,10:2",
    }, delimiter = ':')
    public void judgeMatchCount(String inputLottoNumbers, String inputLuckyNumbers, int expected) {
        Lotto lotto = new Lotto(LottoParser.parse(inputLottoNumbers));
        LuckyNumbers luckyNumbers = new LuckyNumbers(inputLuckyNumbers);
        assertThat(luckyNumbers.matchCount(lotto)).isEqualTo(expected);
    }

    @DisplayName("당첨 번호와 주어진 로또의 일치하는 갯수에 따른 당첨금을 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:2000000000",
            "1,2,3,4,5,6:1,2,3,4,5,7:1500000",
            "1,2,3,4,5,6:1,2,3,4,7,8:50000",
            "1,2,3,4,5,6:1,2,3,7,8,9:5000",
            "1,2,3,4,5,6:1,2,7,8,9,10:0",
    }, delimiter = ':')
    public void judgePrizeMoney(String inputLottoNumbers, String inputLuckyNumbers, int expected) {
        LottoBundle lottoBundle = parseLottoBundles(inputLottoNumbers);
        LuckyNumbers luckyNumbers = new LuckyNumbers(inputLuckyNumbers);

        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundle);
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
        LuckyNumbers luckyNumbers = new LuckyNumbers(luckyNumber);
        LottoBundle lottoBundles = parseLottoBundles(lottoBundle);
        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundles);
        Integer[] expectedCount = parseExpected(expected);

        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_6)).isEqualTo(expectedCount[0]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_5)).isEqualTo(expectedCount[1]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_4)).isEqualTo(expectedCount[2]);
        assertThat(lottoResult.is(RESULT_RANK.RANK_MATCH_3)).isEqualTo(expectedCount[3]);
    }

    private Integer[] parseExpected(String expected) {
        String[] expects = expected.split(":");
        return StringUtil.convertToIntegerArray(expects);
    }

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
            //expected = 1ST:2ND:3RD:4TH (count)
            "1,2,3,4,5,6|1,2,3,4,5,6|2000000.00", // 2_000_000_000 / 1_000 = 2_000_000
            "1,2,3,4,5,6|1,2,3,4,5,7|1500.00", // 1_500_000 / 1_000 = 1_500
            "1,2,3,4,5,6|1,2,3,4,7,8|50.00", // 50_000 / 1_000 = 50
            "1,2,3,4,5,6|1,2,3,7,8,9|5.00", // 5_000 / 1_000 = 5
            "1,2,3,4,5,6|1,2,7,8,9,10|0.00", // 0 / 1_000 = 0
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,7,8,9,10|400311.00", // 2_001_555_000 / 5_000 = 400_311
            "1,2,3,4,5,6|1,2,3,4,5,6:1,2,3,4,5,7:1,2,3,4,7,8:1,2,3,7,8,9:1,2,3,7,8,9|400312.00", // 2_001_560_000 / 5_000 = 400_312
            "1,2,3,4,5,6|" + SPEC_TEST_CASE + "|0.35", // / 5_000 / 14_000
    }, delimiter = '|')
    public void rateOfReturn(String luckyNumber, String lottoBundle, String expected) {
        LuckyNumbers luckyNumbers = new LuckyNumbers(luckyNumber);
        LottoBundle lottoBundles = parseLottoBundles(lottoBundle);
        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundles);

        String rate = StringUtil.floorFloatWithPointPosition(lottoResult.rateOfReturn(),2);
        assertThat(rate).isEqualTo(expected);
    }

    private LottoBundle parseLottoBundles(String lottoBundle) {
        String[] lottos = lottoBundle.split(":");
        List<Lotto> lottoList = new ArrayList<>();
        for(String lotto : lottos) {
            lottoList.add(new Lotto(LottoParser.parse(lotto)));
        }
        return new LottoBundle(lottoList);
    }
}

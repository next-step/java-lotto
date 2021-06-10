package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.lotto.result.ResultRank;
import kr.aterilio.nextstep.techcamp.m1.utils.JUnitParser;
import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LuckyNumbersTest {

    private static final int BONUS_BALL = 45;

    @DisplayName("입력받는 당첨 번호는 쉼표(,)로 분리되는 숫자의 나열이며 공백은 무시한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "5, 2, 3, 1, 6, 7:6"}, delimiter = ':')
    public void createLuckyNumbers(String inputLuckyNumbers, int count) {
        LuckyNumbers luckyNumbers = new LuckyNumbers(inputLuckyNumbers, BONUS_BALL);
        assertThat(luckyNumbers.count()).isEqualTo(count);
    }

    @DisplayName("입력받는 당첨 번호의 갯수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,2,1", "5, 2, 3", "1,2,3,4,5,6,7"})
    public void createLuckyNumbersFailed_count(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers, BONUS_BALL);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,t,1", "5, t, 3"})
    public void createLuckyNumbersFailed_notInteger(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers, BONUS_BALL);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @DisplayName("당첨 번호에 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "-1,2,3,4,5,6"})
    public void createLuckyNumbersFailed_outOfRange(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers, BONUS_BALL);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1", "6,2,3,4,5,6"})
    public void createLuckyNumbersFailed_duplicated(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers, BONUS_BALL);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호와 주어진 로또의 일치하는 갯수를 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6+7:1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,6+7:1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,6+7:1,2,3,4,5,8:THIRD",
            "1,2,3,4,5,6+7:1,2,3,4,7,8:FOURTH",
            "1,2,3,4,5,6+7:1,2,3,7,8,9:FIFTH",
    }, delimiter = ':')
    public void judgeMatchCount(String inputLuckyNumbers, String inputLottoNumbers, ResultRank expected) {
        Lotto lotto = new Lotto(LottoParser.parse(inputLottoNumbers));
        LuckyNumbers luckyNumbers = JUnitParser.parseLuckyNumber(inputLuckyNumbers);
        assertThat(luckyNumbers.rank(lotto)).isEqualTo(expected);
    }
}

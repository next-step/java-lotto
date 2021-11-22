package lotto.domain;

import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    /**
     * - Lotto
     * - 생성 시 LottoNumber의 배열이 6자리가 아니면 runtime exception
     * - getCountOfMatch() 비교 후 일치하는 숫자의 갯수를 반환
     * - LottoNumber 배열 sort()
     */

    @DisplayName("LottoNumber의 배열이 6자리가 아니면 runtime exception")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5"})
    void notNumberTest(String input) {
        List<LottoNumber> lottoNumberList = createLottoNumberList(input);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.create(lottoNumberList));
    }

    @DisplayName("생성 시 오름차순으로 정렬된다.")
    @ParameterizedTest
    @CsvSource(value = {"6,5,4,3,2,1:1,2,3,4,5,6", "10,5,34,42,35,45:5,10,34,35,42,45"}, delimiter = ':')
    void sortTest(String input, String expectStr) {
        Lotto actual = Lotto.create(createLottoNumberList(input));
        Lotto expect = Lotto.create(createLottoNumberList(expectStr));

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("getCountOfMatch() 일치하는 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,7,8,9:3", "1,2,3,4,5,6:7,8,9,10,11,12:0", "10,5,34,42,35,45:5,11,12,13,14,15:1", "1,2,3,4,5,6:1,2,3,4,5,6:6"}, delimiter = ':')
    void sortTest(String input, String compareStr, long expect) {
        Lotto myLotto = Lotto.create(input);
        Lotto winningLotto = Lotto.create(compareStr);

        assertThat(myLotto.getCountOfMatch(winningLotto)).isEqualTo(expect);
    }

    @DisplayName("Winning Lotto 안에 bonus가 있으면 illegal exception")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1", "1,2,3,4,5,6:2", "1,2,3,4,5,6:3", "1,2,3,4,5,6:4", "1,2,3,4,5,6:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void validBonus(String winningLottoStr, String bonusStr) {
        LottoNumber bonus = LottoNumber.create(bonusStr);

        Lotto winningLotto = Lotto.create(Arrays.stream(winningLottoStr.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));

        assertThatIllegalArgumentException().isThrownBy(() -> winningLotto.validBonus(bonus));

    }

    private List<LottoNumber> createLottoNumberList(String input) {
        return Arrays.stream(input.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList());
    }
}

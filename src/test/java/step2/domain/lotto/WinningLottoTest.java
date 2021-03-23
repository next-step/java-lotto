package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6,1    :15:false",
            "1,2,3,4,5        :15:false",
            "1,2,3,4:10       :15:false",
            "1,2,3,3,4,5      :15:false",
            "-1,1,2,3,4,5     :15:false",
            "1,2,3,4,5,46     :15:false",
            "1,2,3,4,5,6,7    :15:false",
            "1,2,3,4,5,6      :6 :false",
            "1,2,3,4,5,6      :46:false",
            "1,2,3,4,5,6      :-1:false",
            "1,2,3,4,5,6      :15:true",
            "40,41,42,43,44,45:15:true"}, delimiter = ':')
    @DisplayName("로또가 올바른지 판단할 수 있다")
    void determinesValidLotto(String rawLotto, int bonusNumber, boolean expected) {
        String dummyString = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(dummyString, 7);

        List<Integer> numbers = Arrays.stream(rawLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean valid = winningLotto.valid(numbers, bonusNumber);
        assertThat(valid).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6,1    :15",
            "1,2,3,4,5        :15",
            "1,2,3,4:10       :15",
            "1,2,3,3,4,5      :15",
            "-1,1,2,3,4,5     :15",
            "1,2,3,4,5,46     :15",
            "1,2,3,4,5,6,7    :15",
            "1,2,3,4,5,6      :6",
            "1,2,3,4,5,6      :46",
            "1,2,3,4,5,6      :-1"}, delimiter = ':')
    @DisplayName("로또가 올바르지 않으면 생성자에서 에러를 던진다")
    void invalidLottoThrowsException(String rawLotto, int bonusNumber) {
        List<Integer> numbers = Arrays.stream(rawLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 : 7 : 8,9,10,11,12,13: false",
            "1,2,3,4,5,6 : 7 : 1,2,3,10,20,30 : false",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,10,20  : false",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,10   : false",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,7    : true",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,6    : false"}, delimiter = ':')
    @DisplayName("보너스 번호가 맞았는지 알 수 있다")
    void determineBonusMatch(String winningString, int rawBonusNumber, String boughtString, boolean expected) {
        WinningLotto winningLotto = new WinningLotto(winningString, rawBonusNumber);
        List<Integer> numbers = Arrays.stream(boughtString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        NormalLotto normalLotto = new NormalLotto(numbers);
        boolean bonusMatch = winningLotto.matchBonus(normalLotto);
        assertThat(bonusMatch).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 : 7 : 8,9,10,11,12,13: 0",
            "1,2,3,4,5,6 : 7 : 1,2,3,10,20,30 : 3",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,10,20  : 4",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,10   : 5",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,7    : 5",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,6    : 6"}, delimiter = ':')
    @DisplayName("일반 번호가 몇개 맞았는지 알 수 있다")
    void determineNumberMatch(String winningString, int rawBonusNumber, String boughtString, int expected) {
        WinningLotto winningLotto = new WinningLotto(winningString, rawBonusNumber);
        List<Integer> numbers = Arrays.stream(boughtString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        NormalLotto normalLotto = new NormalLotto(numbers);
        int matchCount = winningLotto.matchCount(normalLotto);
        assertThat(matchCount).isEqualTo(expected);
    }

}

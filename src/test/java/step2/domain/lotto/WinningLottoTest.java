package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6,1    :15",
            "1,2,3,4,5        :15",
            "1,2,3,4:10       :15",
            "1,2,3,3,4,5      :15",
            "1,2,3,4,5,6,7    :15",
            "1,2,3,4,5,6      :6"}, delimiter = ':')
    @DisplayName("로또가 올바르지 않으면 생성자에서 에러를 던진다")
    void invalidLottoThrowsException(String rawLotto, int bonusNumber) {
        CustomException thrown = assertThrows(CustomException.class, () -> new WinningLotto(rawLotto, bonusNumber));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_WINNING_LOTTO_NUMBERS);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,1,2,3,4,5     :15",
            "1,2,3,4,5,46     :15",
            "1,2,3,4,5,6      :46",
            "1,2,3,4,5,6      :-1"}, delimiter = ':')
    @DisplayName("로또번호가 올바르지 않으면 생성자에서 에러를 던진다")
    void invalidLottoNumberThrowsException(String rawLotto, int bonusNumber) {
        CustomException thrown = assertThrows(CustomException.class, () -> new WinningLotto(rawLotto, bonusNumber));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_LOTTO_NUMBER);
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
        NormalLotto normalLotto = new NormalLotto(boughtString);
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
        NormalLotto normalLotto = new NormalLotto(boughtString);
        int matchCount = winningLotto.matchCount(normalLotto);
        assertThat(matchCount).isEqualTo(expected);
    }

}

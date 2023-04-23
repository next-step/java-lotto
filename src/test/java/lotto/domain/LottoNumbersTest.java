package lotto.domain;


import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    final LottoStrategy testStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final LottoNumbers lottoNumbers = new LottoNumbers(testStrategy);

        assertThat(lottoNumbers)
                .extracting("lottoNumbers")
                .isNotNull()
                .asList()
                .hasSize(6);
    }

    @Test
    @DisplayName("우승 번호 객체 생성 테스트")
    void createWinningNumbers() {
        final String args = "1, 2, 3, 4, 5, 6";
        final LottoNumbers winningNumbers = LottoNumbers.winningNumbers(args);

        assertThat(winningNumbers)
                .isEqualTo(LottoNumbers.winningNumbers(args));
    }

    @Test
    @DisplayName("숫자로 파싱될 수 없는 다른 값이 올 경우 exception 반환")
    void checkInt() {
        final String args = "1, 2, ㄴ, 4, 5, 6";

        assertThatThrownBy(() -> LottoNumbers.winningNumbers(args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6자리의 숫자가 오지 않았을 경우 exception 반환")
    void checkSize() {
        final String args = "1, 2, 3, 4, 5";

        assertThatThrownBy(() -> LottoNumbers.winningNumbers(args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 이 올 경우 exception 반환")
    void checkNull() {
        final String args = null;

        assertThatThrownBy(() -> LottoNumbers.winningNumbers(args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호가 몇 개 맞는지 통계확인 테스트")
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3", "1,2,7,8,9,11:2", "1,7,8,9,10,11:1", "7,8,9,10,11,12:0"}, delimiter = ':')
    void statCount(String target, int result) {
        final LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");

        assertThat(lottoNumbers.statCount(new LottoNumbers(target)))
                .isEqualTo(result);
    }
}

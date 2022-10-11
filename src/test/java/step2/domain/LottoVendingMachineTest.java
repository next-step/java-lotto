package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoVendingMachineTest {
    @DisplayName("makeLottoNumberWithTimes 성공: 시도횟수와 기록의 길이가 같아야 함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(ints = {1, 10})
    void makeLottoNumberWithTimes(int numberOfLotto) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(new RandomGenerator());
        List<LottoNumber> gambleHistory = lottoVendingMachine.makeLottoNumberWithTimes(numberOfLotto);
        assertThat(gambleHistory.size()).isEqualTo(numberOfLotto);
    }
}
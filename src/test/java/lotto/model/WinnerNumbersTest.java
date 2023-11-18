package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {

    @Test
    @DisplayName("당첨 번호 중 해당 번호가 있는지 확인")
    void test1() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3),
                new PositiveNumber(4),
                new PositiveNumber(5),
                new PositiveNumber(6)));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(new PositiveNumber(7)));
        assertThat(winnerNumbers.has(new PositiveNumber(3))).isTrue();
        assertThat(winnerNumbers.has(new PositiveNumber(7))).isFalse();
    }

    @Test
    @DisplayName("보너스볼은 당첨번호와 중복되지 않는다")
    void test2() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3),
                new PositiveNumber(4),
                new PositiveNumber(5),
                new PositiveNumber(6)));
        BonusBall bonusBall = new BonusBall(new PositiveNumber(6));
        assertThatThrownBy(() -> new WinnerNumbers(lottoNumbers, bonusBall))
                .hasMessageContaining("중복");
    }

}
package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {

    @Test
    @DisplayName("당첨 번호 중 해당 번호가 있는지 확인")
    void test1() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(new LottoNumberValidate(7)));
        //then
        assertThat(winnerNumbers.has(new LottoNumberValidate(3))).isTrue();
        assertThat(winnerNumbers.has(new LottoNumberValidate(7))).isFalse();
    }

    @Test
    @DisplayName("보너스볼은 당첨번호와 중복되지 않는다")
    void test2() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        BonusBall bonusBall = new BonusBall(new LottoNumberValidate(6));
        assertThatThrownBy(() -> new WinnerNumbers(lottoNumbers, bonusBall))
                .hasMessageContaining("중복");
    }

}
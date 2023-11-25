package lotto.model;

import lotto.model.constants.Dividend;
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
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(LottoNumber.of(7)));
        //then
        assertThat(winnerNumbers.has(LottoNumber.of(3))).isTrue();
        assertThat(winnerNumbers.has(LottoNumber.of(7))).isFalse();
    }

    @Test
    @DisplayName("보너스볼은 당첨번호와 중복되지 않는다")
    void test2() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(6));
        assertThatThrownBy(() -> new WinnerNumbers(lottoNumbers, bonusBall))
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("등수에 따른 당첨금을 리턴한다")
    void test3() {
        //given
        LottoNumbers winnerLottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(7));
        WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLottoNumbers, bonusBall);

        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)));
        Lotto lotto = new Lotto(lottoNumbers);
        //then
        assertThat(winnerNumbers.winnerMoney(lotto)).isEqualTo(30000000L);
    }

    @Test
    @DisplayName("맞춘 개수에 따른 올바른 Rank를 리턴한다")
    void test4() {
        //given
        LottoNumbers winnerLottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(7));
        WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLottoNumbers, bonusBall);

        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)));
        Lotto lotto = new Lotto(lottoNumbers);
        //then
        assertThat(winnerNumbers.winResult(lotto)).isEqualTo(Dividend.SECOND);
    }
}
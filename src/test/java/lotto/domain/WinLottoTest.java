package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    @DisplayName("당첨 로또는 번호 6개와 보너스 번호를 가질 수 있다.")
    void winLottoGenerateTest() {

        // given
        List<LottoNumber> numbers = Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        LottoNumber bonusNumber = LottoNumber.of(7);

        // when
        WinLotto winLotto = new WinLotto(new Lotto(numbers), bonusNumber);

        // then
        assertThat(winLotto.lotto()).isEqualTo(new Lotto(numbers));
        assertThat(winLotto.bonus()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 로또의 기본 로또 번호도 오름차순으로 저장되어있어야 한다.")
    void winLottoAscTest() {

        // given
        List<LottoNumber> numbers = Arrays.asList(6, 5, 4, 3, 2, 1)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        LottoNumber bonusNumber = LottoNumber.of(7);

        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));

        // when
        WinLotto winLotto = new WinLotto(new Lotto(numbers), bonusNumber);

        // then
        assertThat(winLotto.lotto()).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 로또가 있으면 로또의 등수를 알 수 있다.")
    void getRankByWinLottoTest() {

        // given
        Lotto compare = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));
        LottoNumber bonus = LottoNumber.of(6);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        // when
        Rank result = winLotto.calculateRank(compare);

        // then
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복되면 Exception이 발생해야 한다.")
    void lottoNumberAndBonusNumberDuplicateTest() {

        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));
        LottoNumber bonus = LottoNumber.of(6);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinLotto(lotto, bonus))
            .withMessageMatching("로또의 번호와 보너스 번호는 중복될 수 없다.");
    }

}
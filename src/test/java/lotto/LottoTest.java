package lotto;

import common.StringToLottoNumberConverter;
import common.StringToLottoNumberSetConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("로또는 구입 금액이 있다")
    @Test
    void lottoPrice() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }

    @DisplayName("구매 로또는 6개의 당첨 번호로 구성되어 있다")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6",
            "2 3 4 5 6 7"
    })
    void lottoNumbers(@ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers) {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("구매 로또의 당첨 번호가 6개가 아니면 예외를 발생한다")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5",
            "2 3 4 5 6"
    })
    void notSixNumber(@ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers));
    }

    @DisplayName("당첨 로또와 2개 숫자 이하는 꽝")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 2 9 10 11 12, 13"
    })
    void underTwoMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("당첨 로또와 3개 숫자가 일치")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 10 11 12, 13"
    })
    void threeMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨 로또와 4개 숫자가 일치")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 4 11 12, 13"
    })
    void fourMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("당첨 로또와 5개 숫자가 일치")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 4 5 12, 13"
    })
    void fiveMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨 로또와 5개 숫자와 1개 보너스 숫자가 일치")
    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 4 5 12, 6"
    })
    void fiveAndBonusMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("당첨 로또와 6개 숫자가 일치")
    @ParameterizedTest(name = "당첨 로또와 6개 숫자가 일치")
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 4 5 6, 7"
    })
    void sixMatched(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.FIRST);
    }
}
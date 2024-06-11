package lotto;

import common.converter.StringToLottoNumberConverter;
import common.converter.StringToLottoNumberSetConverter;
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

    @DisplayName("로또 당첨 테스트")
    @ParameterizedTest(name = "{displayName} - {3}")
    @CsvSource({
            "1 2 3 4 5 6, 1 2 3 4 5 6, 7, FIRST",
            "1 2 3 4 5 6, 1 2 3 4 5 12, 6, SECOND",
            "1 2 3 4 5 6, 1 2 3 4 5 12, 13, THIRD",
            "1 2 3 4 5 6, 1 2 3 4 11 12, 13, FOURTH",
            "1 2 3 4 5 6, 1 2 3 10 11 12, 13, FIFTH",
            "1 2 3 4 5 6, 1 2 9 10 11 12, 13, NONE",
    })
    void matchTest(
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> numbers,
            @ConvertWith(StringToLottoNumberSetConverter.class) final Set<LottoNumber> winningNumbers,
            @ConvertWith(StringToLottoNumberConverter.class) final LottoNumber bonus,
            LottoRank lottoRank
    ) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        assertThat(lotto.match(winningLotto)).isEqualTo(lottoRank);
    }
}
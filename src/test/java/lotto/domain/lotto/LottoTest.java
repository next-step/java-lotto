package lotto.domain.lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.TestUtil.numbersForTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Nested
    @DisplayName("Lotto 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Test
        @DisplayName("lottoNumbers의 크기가 LOTTO_NUMBER_SIZE와 다른 경우 InvalidLottoException이 발생한다.")
        void testWrongSizeFailCase() {
            List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
                    .map(LottoNumber::valueOf)
                    .collect(Collectors.toList());

            assertThatThrownBy(() -> Lotto.valueOf(lottoNumbers))
                    .isExactlyInstanceOf(InvalidLottoException.class);
        }

        @Test
        @DisplayName("lottoNumbers에 중복된 번호가 포함된 경우 InvalidLottoException이 발생한다.")
        void testDuplicateFailCase() {
            List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 6, 6)
                    .map(LottoNumber::valueOf)
                    .collect(Collectors.toList());

            assertThatThrownBy(() -> Lotto.valueOf(lottoNumbers))
                    .isExactlyInstanceOf(InvalidLottoException.class);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"8, 21, 23, 41, 42, 43:0", "1, 3, 5, 14, 22, 45:3", "1, 3, 2, 4, 6, 5:6"}, delimiter = ':')
    @DisplayName("countOfMatch(): 로또 번호와 당첨 번호가 일치하는 번호의 개수를 반환한다.")
    void testCountOfMatch(String winningNumberInput, int expected) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        WinningNumbers winningNumbers = WinningNumbers.valueOf(numbersForTest(winningNumberInput));
        Lotto lotto = Lotto.valueOf(lottoNumbers);

        assertThat(lotto.countOfMatch(winningNumbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    @DisplayName("contains(): bonusNumber가 Lotto.lottoNumbers에 포함되어 있는 경우 true 그렇지 않는 경우 false를 반환한다.")
    void testContains(int bonusNumberInput, boolean expected) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        Lotto lotto = Lotto.valueOf(lottoNumbers);
        BonusNumber bonusNumber = new BonusNumber(LottoNumber.valueOf(bonusNumberInput));

        assertThat(lotto.contains(bonusNumber)).isEqualTo(expected);
    }
}

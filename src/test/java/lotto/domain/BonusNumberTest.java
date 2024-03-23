package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.exception.InValidBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("BonusNumber 인스턴스 생성시 bonusNumber가 winningNumbers와 겹치는 경우 ")
    void testInstanceCreationFailCase() {
        WinningNumbers winningNumbers = WinningNumbers.valueOf(new HashSet<>(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6))));

        LottoNumber bonusNumber = LottoNumber.valueOf(6);

        assertThatThrownBy(() -> BonusNumber.newBonusNumberWithOutWinningNumbers(bonusNumber, winningNumbers))
                .isExactlyInstanceOf(InValidBonusNumberException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:2:false"}, delimiter = ':')
    @DisplayName("isMatched(): bonusNumber와 lottoNumber가 일치하는 경우 true 그렇지 않은 경우 false를 반환한다.")
    void testIsMatched(int bonusNumberInput, int lottoNumberInput, boolean expected) {
        BonusNumber bonusNumber = new BonusNumber(LottoNumber.valueOf(bonusNumberInput));
        LottoNumber lottoNumber = LottoNumber.valueOf(lottoNumberInput);

        assertThat(bonusNumber.isMatched(lottoNumber)).isEqualTo(expected);
    }
}

package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    @DisplayName("hasMatched(): bonusNumber가 lottoNumbers에서 일치하는게 있다면 true 그렇지 않은 경우 false를 반환한다.")
    void testhasMatched(int bonusNumberInput, boolean expected) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        BonusNumber bonusNumber = BonusNumber.valueOf(LottoNumber.valueOf(bonusNumberInput));

        assertThat(bonusNumber.isMatched(lottoNumbers)).isEqualTo(expected);
    }
}

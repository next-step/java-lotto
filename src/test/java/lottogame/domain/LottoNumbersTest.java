package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    @DisplayName("중복된 로또 번호가 있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionForDuplicationNumber() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(createLottoNumbers(1, 1, 3, 2, 5, 6));
        });
    }

    @DisplayName("일치하는 번호의 개수를 반환한다.")
    @Test
    void countMatchingNumbers() {
        LottoNumbers numbers1 = new LottoNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoNumbers numbers2 = new LottoNumbers(createLottoNumbers(1, 2, 3, 7, 8, 9));

        int actual = numbers1.countMatchingNumbers(numbers2);

        assertEquals(3, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "11:false", "45:false"}, delimiter = ':')
    @DisplayName("보너스 번호 일치 여부를 반환한다.")
    void isMatchingBonus(int bonusNo, boolean expected) {
        LottoNumbers number = new LottoNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(bonusNo);

        boolean actual = number.isMatchingBonus(bonusNumber);

        assertEquals(expected, actual);
    }

    private List<LottoNumber> createLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

}

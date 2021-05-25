package lotto.model;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("로또 생성시 로또 번호 리스트의 길이가 6이 아니면 에러.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void validateLottoListSizeTest(int number) {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(number));
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(lottoNumberList);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또 생성시 발생하는 2가지 에러 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,6,7"})
    void validateLottoListTest(String names) {
        List<String> StringNames = Arrays.asList(names.split(","));
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String name : StringNames) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(name)));
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또에서 로또 번호 리스트를 가져올 수 있다.")
    @Test
    void getLottoNumbersTest() {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.makeLottoNumber();

        assertThat(new Lotto(lottoNumbers)
                .getLottoNumbers()
                .size()).isEqualTo(Lotto.CORRECT_LOTTO_NUMBERS_SIZE);
    }
}

package lotto.model;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성시 로또 번호 리스트의 길이가 6이 아니면 에러.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    void validateLottoListSizeTest(int number) {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(number));
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(lottoNumberList);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

/*    @DisplayName("로또 생성시 로또 번호 리스트가 중복되면 에러.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,6})
    void validateLottoListDuplicateTest(int number) {
        Set<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(number));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }*/

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

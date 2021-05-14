package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성시 로또 번호 리스트의 길이가 6이 아니면 에러.")
    @Test
    void validateLottoListSizeTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또 생성시 로또 번호 리스트가 중복되면 에러.")
    @Test
    void validateLottoListDuplicateTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 6, 6);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또 생성시 로또 번호 리스트 범위가 1~45를 벗어나면 에러")
    @Test
    void validateLottoListRangeTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 47);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또 생성시 발생하는 3가지 에러 검증")
    @ParameterizedTest
    @ValueSource(strings ={"1,2,3,4,5,47","1,2,3,4,5,5","1,2,3,4,5,6,7"})
    void validateLottoListTest(String names) {
        List<String> StringNames = Arrays.asList(names.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String name: StringNames){
            lottoNumbers.add(Integer.parseInt(name));
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또에서 로또 번호 리스트를 가져올 수 있다.")
    @Test
    void getLottoNumbersTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.makeLottoNumbers();

        assertThat(new Lotto(lottoNumbers)
                .getLottoNumbers()
                .size()).isEqualTo(Lotto.CORRECT_LOTTO_NUMBERS_SIZE);
    }
}

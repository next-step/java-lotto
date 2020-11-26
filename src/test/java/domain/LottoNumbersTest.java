package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    private final String NUMBER_DELIMITER = ", ";

    LottoNumbers lottoNumbers;

    @Test
    @DisplayName("정답 로또 생성")
    void winningNumbers() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";

        lottoNumbers = new LottoNumbers();
        LottoNumbers winningLotto = lottoNumbers.createLottoNumbers(winningNumbers.split(NUMBER_DELIMITER));

        assertThat(winningLotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호 중복 검사")
    void checkDuaplicateNumber() {
        List<Integer> duplicateNumber = Arrays.asList(1, 1, 2, 3, 4, 5);

        lottoNumbers = new LottoNumbers();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoNumbers.from(duplicateNumber));
    }

}

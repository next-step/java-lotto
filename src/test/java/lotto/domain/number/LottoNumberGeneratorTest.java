package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("인자로 받은 개수 만큼 LottoNumber의 Set을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void generateRandomNumber(int size) {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.generateRandomNumber(size);

        assertThat(lottoNumbers.size()).isEqualTo(size);
    }

    @DisplayName("인자로 받은 숫자 리스트를 LottoNumber로 변환하여 Set으로 반환한다.")
    @Test
    void generateFixedNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(LottoNumberGenerator.generateFixedNumber(numbers)).contains(LottoNumber.valueOf(3));
    }
}
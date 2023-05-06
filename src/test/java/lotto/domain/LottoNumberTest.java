package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberTest {
    @Test
    void of단건테스트() {
        LottoNumber lottoNumber = LottoNumber.of(5);

        Assertions.assertThat(lottoNumber.toString()).isEqualTo("5");
    }

    @Test
    void of다건테스트() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 6, 25, 30, 35, 45));

        List<LottoNumber> lottoNumber = LottoNumber.of(numbers);

        Assertions.assertThat(lottoNumber.toString()).isEqualTo("[1, 5, 6, 25, 30, 35, 45]");
    }

    @DisplayName("로또값가져오기")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 로또값가져오기(int count) {
        List<LottoNumber> lottoNumber = LottoNumber.getRandomNumbers(count);

        Assertions.assertThat(lottoNumber.size()).isEqualTo(count);
    }
}

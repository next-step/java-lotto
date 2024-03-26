package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringToListConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1, 2, 3"})
    @DisplayName("리스트로 바꿀 숫자열은 ','로 구분하며 빈칸 여부는 영향을 주지 않는다. ")
    void make_list(String input) {

        assertThat(StringToListConverter.toList(input)).isEqualTo(Arrays.asList(1,2,3));
    }
}

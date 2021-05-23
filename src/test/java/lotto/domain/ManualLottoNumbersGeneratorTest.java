package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoNumbersGeneratorTest {

    private List<String> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
    }

    @Test
    @DisplayName("수동으로 입력한 로또 번호를 발급한다")
    void createManualLottoNumbersTest() {
        int manualLottoCount = 2;
        ManualLottoNumbersGenerator lottoNumbersGenerator = new ManualLottoNumbersGenerator(manualLottoCount, numbers);

        List<LottoNumbers> manualLottoNumbers = lottoNumbersGenerator.generate();
        assertThat(manualLottoNumbers).hasSize(manualLottoCount);
        assertThat(manualLottoNumbers).containsExactly(LottoNumbers.of("1,2,3,4,5,6"), LottoNumbers.of("2,3,4,5,6,7"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("provideListForString")
    @DisplayName("수동 구매 개수와 수동 번호 개수가 다른 경우 예외가 발생한다")
    void manualCountMatchTest(List<String> numbers) {
        int manualLottoCount = 3;
        assertThatThrownBy(() -> new ManualLottoNumbersGenerator(manualLottoCount, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideListForString() {
        return Stream.of(
                Arguments.of(Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7")),
                Arguments.of(Collections.singletonList("1,2,3,4,5,6"))
        );
    }
}

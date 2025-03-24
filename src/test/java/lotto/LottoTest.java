package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    @DisplayName("로또 번호가 6개 아니면 에러를 반환한다.")
    public void invalidLottoNumberSize(List<Integer> numbers){
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of("1,2,3,4,5"))
                , Arguments.of(List.of("1,2,3,4,5,6,7"))
        );
    }
}
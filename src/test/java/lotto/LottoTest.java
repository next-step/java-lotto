package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class LottoTest {

    @Test
    @DisplayName("로또를  생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_생성_테스트(){
        assertThatCode(() -> Lotto.of(new ArrayList<>())).doesNotThrowAnyException();
    }

    @MethodSource("generate_lotto_numbers")
    @ParameterizedTest
    @DisplayName("로또를 정렬하고 정렬됐는지 검증한다.")
    void 로또_정렬_테스트(List<Integer> lottoNumbers){
        Lotto lotto = Lotto.of(lottoNumbers);
        lotto.sort();
        assertThat(lotto.getLottoNumbers()).isSorted();
    }

    private static Stream<Arguments> generate_lotto_numbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(23, 45, 32, 14, 2, 3, 7))
        );
    }
}

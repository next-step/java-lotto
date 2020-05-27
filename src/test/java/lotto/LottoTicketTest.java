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

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTicketTest {

    @Test
    @DisplayName("로또를  생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_생성_테스트() {
        assertThatCode(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @MethodSource("generate_lotto_numbers")
    @ParameterizedTest
    @DisplayName("로또를 정렬하고 정렬됐는지 검증한다.")
    void 로또_정렬_테스트(List<Integer> lottoNumbers) {
        LottoTicket lotto = LottoTicket.of(lottoNumbers);
        lotto.sort();
        assertThat(lotto.getLottoNumbers()).isSorted();
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 크기가 6보다 작으면 예외가 발생한다.")
    void 로또_번호_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 번호가 중복되면 예외가 발생한다.")
    void 로또_번호_중복_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }

    @MethodSource("generate_invalid_range_lotto_numbers")
    @ParameterizedTest
    @DisplayName("로또 티켓을 생성하는데 크기가 숫자가 1보다 작거나 45보다 크면 예외가 발생한다.")
    void 로또_번호_범위_예외_테스트(List<Integer> lottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(lottoNumbers));
    }

    private static Stream<Arguments> generate_lotto_numbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(23, 45, 32, 14, 2, 3))
        );
    }

    private static Stream<Arguments> generate_invalid_range_lotto_numbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 46, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(2, 45, 32, 14, 2, 3))
        );
    }
}

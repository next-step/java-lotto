package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {

    @Test
    @DisplayName("로또 번호를 저장한다.")
    void lottoTicket_save() {
        // 로또 번호 생성
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        LottoGenerator lottoGenerator = () -> new Lotto(lottoNumbers);

        Lotto lotto = lottoGenerator.generateLotto();

        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    @DisplayName("입력 숫자가 6개가 아닌경우 Exception 발생한다.")
    void input_count_not_six_exception_test(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() ->
                new Lotto(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
                arguments(Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6),
                        LottoNumber.of(7))
                ),
                arguments(Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5))
                )
        );
    }
}

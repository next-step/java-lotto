package lotto.utils;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.utils.Splitter.INVALID_INPUT_VALUE_ERROR_MESSAGE;
import static lotto.utils.Splitter.INVALID_LOTTO_SIZE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SplitterTest {

    @DisplayName("로또 번호 Splitter는")
    @Nested
    class Describe_splitter_split {

        @DisplayName("입력한 번호가 주어지면")
        @Nested
        class Context_input_lotto_numbers {
            final String input = "1,2,3,4,5,6";

            @DisplayName("콤마를 기준으로 split 한다.")
            @Test
            void It_split_by_comma() {
                final List<LottoNumber> lottoNumbers = Splitter.split(input);
                assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
            }
        }

        @DisplayName("숫자가 아닌 값을 넣으면")
        @Nested
        class Context_input_invalid_value {
            final String input1 = "1,2,3,4,5,q";
            final String input2 = "1,,3,4,www,q";
            final String input3 = "1,23,3s3a,4,5123aa,q";

            @DisplayName("에러를 발생시킨다.")
            @ParameterizedTest
            @ValueSource(strings = {input1, input2, input3})
            void It_exeption(final String input) {
                assertThatIllegalArgumentException().isThrownBy(() -> Splitter.split(input))
                        .withMessageMatching(INVALID_INPUT_VALUE_ERROR_MESSAGE);
            }
        }

        @DisplayName("숫자를 덜 넣으면")
        @Nested
        class Context_input_less_than_size {
            final String input1 = "1,2,3,4,5";
            final String input2 = "1,2,3,4";
            final String input3 = ",";

            @DisplayName("에러를 발생시킨다.")
            @ParameterizedTest
            @ValueSource(strings = {input1, input2, input3})
            void It_exeption(final String input) {
                assertThatIllegalArgumentException().isThrownBy(() -> Splitter.split(input))
                        .withMessageMatching(INVALID_LOTTO_SIZE_ERROR_MESSAGE);
            }
        }
    }
}

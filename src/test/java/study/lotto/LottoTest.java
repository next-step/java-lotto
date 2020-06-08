package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.model.Lotto;
import study.lotto.model.LottoNumber;
import study.lotto.model.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {

    @DisplayName("로또 번호 생성 테스트 - 성공")
    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 23, 45 })
    void create_lotto_number_with_proper_values(int value) {
        assertThat(LottoNumber.of(value))
                .isInstanceOf(LottoNumber.class);
    }

    @DisplayName("로또 번호 생성 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 46, 80 })
    void create_lotto_number_with_improper_values(int value) {
        assertThatThrownBy(() -> LottoNumber.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:1", "1:2", "10:20" }, delimiterString = ":")
    void compare_lotto_number(int a, int b) {
        assertThat(LottoNumber.of(a))
                .isLessThanOrEqualTo(LottoNumber.of(b));
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void generate_lotto() {
        Lotto lotto = Lotto.auto();

        assertAll(
                () -> assertThat(lotto.getLottoNumbers())
                        .allMatch(lottoNumber -> lottoNumber.getNumber() > 0 && lottoNumber.getNumber() < 46),
                () -> assertThat(lotto.getLottoNumbers().size()).isEqualTo(6)
        );
    }

    @DisplayName("당첨 번호 대조 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5, 6", "2, 3, 4, 7, 9, 12" })
    void compare_lotto_to_winning_numbers(String input) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);

        String[] split = input.split(", ");
        WinningLotto winningLotto = WinningLotto.of(split);

        assertThat(winningLotto.compareToWinningNumbers(lotto))
                .isEqualTo(3);
    }
}

package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generate_lotto() {
        Lotto lotto = Lotto.generate();

        assertThat(lotto.getLottoNumbers()).allMatch(num -> num>0 && num<46);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호 대조 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5, 6", "2, 3, 4, 7, 9, 12" })
    void compare_lotto_to_winning_numbers(String input) {
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11));

        String[] split = input.split(", ");
        List<Integer> winningNumbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());

        assertThat(lotto.compareToWinningNumbers(winningNumbers))
                .isEqualTo(3);
    }
}

package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.model.Lotto;
import study.lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generate_lotto() {
        Lotto lotto = Lotto.generate();

        assertThat(lotto.getLottoNumbers())
                .allMatch(lottoNumber -> lottoNumber.getNumber()>0 && lottoNumber.getNumber()<46);

        assertThat(lotto.getLottoNumbers().size())
                .isEqualTo(6);
    }

    @DisplayName("당첨 번호 대조 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5, 6", "2, 3, 4, 7, 9, 12" })
    void compare_lotto_to_winning_numbers(String input) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::new).collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);

        String[] split = input.split(", ");
        List<LottoNumber> winningNumbers = Arrays.stream(split).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());

        assertThat(lotto.compareToWinningNumbers(winningNumbers))
                .isEqualTo(3);
    }
}

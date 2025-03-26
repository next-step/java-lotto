package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또를 생성 할 수 있다.")
    @Test
    void createTest() {
        List<LottoNumber> lottoNumbers = getLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 생성 시 길이가 6이 아닌 경우 예외가 발생한다.")
    @Test
    void checkLengthTest() {
        List<LottoNumber> wrongNumbers = getLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(wrongNumbers))
                .withMessage("lotto size is not 6");
    }

    private List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
}

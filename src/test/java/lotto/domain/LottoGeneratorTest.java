package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoGeneratorTest {
// 랜덤성이 포함된 메소드들이어서 테스트 불가

    @DisplayName("comma with space parsing test")
    @Test
    void getWinnerLottoWithSplitting() {
        String input = "1, 2, 3, 4, 5, 6";
        Lotto lotto = LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(LottoGenerator.getLottoWithSplitting(input).getNumbers()).isEqualTo(lotto.getNumbers());
    }

    @DisplayName("can't parsing 6+- length input")
    @Test
    void getWinnerLottoWithSplittingFailIfLengthIsNotSix() {
        String input = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> {
            LottoGenerator.getLottoWithSplitting(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("can't parsing not integer input")
    @Test
    void getWinnerLottoWithSplittingWithNotInteger() {
        String input = "1, 2, a, b, c, d";
        assertThatThrownBy(() -> {
            LottoGenerator.getLottoWithSplitting(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }


}
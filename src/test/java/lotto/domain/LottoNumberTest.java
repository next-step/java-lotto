package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.NumberMatcher;
import lotto.domain.WinningNumberMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("NumberMatcher 를 넣어주면 일치하는 번호 갯수를 알려준다")
    @Test
    void matchedNumberCount() {
        LottoNumber number = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 10, 11, 12, 13, 14))))
                .isEqualTo(1);
        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 2, 11, 12, 13, 14))))
                .isEqualTo(2);
        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 2, 3, 12, 13, 14))))
                .isEqualTo(3);
        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 2, 3, 4, 13, 14))))
                .isEqualTo(4);
        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 2, 3, 4, 5, 14))))
                .isEqualTo(5);
        assertThat(number.getMatchedNumberCount(testMatcher(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(6);
    }

    private NumberMatcher testMatcher(List<Integer> source) {
        return new WinningNumberMatcher(source);
    }

}
package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("NumberMatcher 를 넣어주면 일치하는 번호 갯수를 알려준다")
    @Test
    void matchedNumberCount() {
        LottoNumbers number = new LottoNumbers("1, 2, 3, 4, 5, 6");

        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 10, 11, 12, 13, 14")))
                .isEqualTo(1);
        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 2, 11, 12, 13, 14")))
                .isEqualTo(2);
        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 2, 3, 12, 13, 14")))
                .isEqualTo(3);
        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 2, 3, 4, 13, 14")))
                .isEqualTo(4);
        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 2, 3, 4, 5, 14")))
                .isEqualTo(5);
        assertThat(number.getMatchedNumberCount(listNumberMatcher("1, 2, 3, 4, 5, 6")))
                .isEqualTo(6);
    }

    private LottoNumberMatcher listNumberMatcher(String source) {
        return LottoNumberUtils.listNumberMatcher(source);
    }

    @DisplayName("순서와 관계없이 번호가 동일하면 같은 로또번호다")
    @Test
    void equals(){
        LottoNumbers num1 = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers num2 = new LottoNumbers("2,6,4,5,3,1");

        assertThat(num1.equals(num2)).isTrue();
    }

    @DisplayName("LottoNumbers 를 문자열로 변환할 수 있다")
    @Test
    void to_string(){
        LottoNumbers numbers = new LottoNumbers("1,2,3,4,5,6");

        assertThat(numbers.toString()).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("로또번호에 중복된 번호가 있으면 exception 이 발생한다")
    @Test
    void dupNumber(){
        assertThatThrownBy(() -> new LottoNumbers("1,1,2,3,4,5"))
                .isInstanceOf(LottoNumbersException.class);
    }

}
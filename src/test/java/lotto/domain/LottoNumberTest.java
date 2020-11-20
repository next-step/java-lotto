package lotto.domain;

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

    @DisplayName("순서와 관계없이 번호가 동일하면 같은 로또번호다")
    @Test
    void equals(){
        LottoNumber num1 = LottoUtils.lottoNumber("1,2,3,4,5,6");
        LottoNumber num2 = LottoUtils.lottoNumber("2,6,4,5,3,1");

        assertThat(num1.equals(num2)).isTrue();
    }

    @DisplayName("로또번호를 String 으로 바꿀 수 있다")
    @Test
    void to_string(){
        LottoNumber num = LottoUtils.lottoNumber("1,2,3,4,5,6");

        assertThat(num.toString()).isEqualTo("1,2,3,4,5,6");
    }

    private NumberMatcher testMatcher(List<Integer> source) {
        return new ListNumberMatcher(source);
    }

}
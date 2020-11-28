package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ListLottoNumberMatcherTest {

    @DisplayName("번호가 당첨번호중 하나면 true 를 return 한다")
    @Test
    void match(){
        ListLottoNumberMatcher matcher = LottoNumberUtils.listNumberMatcher("1,2,3,4,5,6");
        assertThat(matcher.match(new LottoNumber(1))).isTrue();
        assertThat(matcher.match(new LottoNumber(2))).isTrue();
        assertThat(matcher.match(new LottoNumber(3))).isTrue();
        assertThat(matcher.match(new LottoNumber(4))).isTrue();
        assertThat(matcher.match(new LottoNumber(5))).isTrue();
        assertThat(matcher.match(new LottoNumber(6))).isTrue();

        assertThat(matcher.match(new LottoNumber(7))).isFalse();
        assertThat(matcher.match(new LottoNumber(8))).isFalse();
        assertThat(matcher.match(new LottoNumber(9))).isFalse();
    }

}
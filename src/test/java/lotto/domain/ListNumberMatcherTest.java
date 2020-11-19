package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ListNumberMatcherTest {

    ListNumberMatcher matcher;

    @DisplayName("번호가 당첨번호중 하나면 true 를 return 한다")
    @Test
    void match(){
        this.matcher = new ListNumberMatcher(Arrays.asList(1,2,3,4,5,6));
        assertThat(this.matcher.match(1)).isTrue();
        assertThat(this.matcher.match(2)).isTrue();
        assertThat(this.matcher.match(3)).isTrue();
        assertThat(this.matcher.match(4)).isTrue();
        assertThat(this.matcher.match(5)).isTrue();
        assertThat(this.matcher.match(6)).isTrue();

        assertThat(this.matcher.match(7)).isFalse();
        assertThat(this.matcher.match(8)).isFalse();
        assertThat(this.matcher.match(9)).isFalse();
    }

}
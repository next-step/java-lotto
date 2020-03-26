package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterStrategyTest {

    @DisplayName("생성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        DelimiterStrategy strategy1 = new DelimiterStrategy("1:1", new Delimiter(":"));
        DelimiterStrategy strategy2 = new DelimiterStrategy("1:1", new Delimiter(":"));

        //then
        assertThat(strategy1.equals(strategy2)).isTrue();
    }

    @DisplayName("생성자 테스트 : fail")
    @Test
    public void construct_fail() throws Exception {
        //given
        DelimiterStrategy strategy1 = new DelimiterStrategy("1:1", new Delimiter(":"));
        DelimiterStrategy strategy2 = new DelimiterStrategy("1:2", new Delimiter(":"));

        //then
        assertThat(!strategy1.equals(strategy2)).isTrue();
    }
}

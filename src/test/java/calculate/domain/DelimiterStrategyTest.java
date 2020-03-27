package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DelimiterStrategyTest {

    @DisplayName("생성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        DelimiterStrategy strategy1 = new DelimiterStrategy("1:1", ":");
        DelimiterStrategy strategy2 = new DelimiterStrategy("1:1", ":");

        //then
        assertThat(strategy1.equals(strategy2)).isTrue();
    }

    @DisplayName("피연산자에 null, ' '이 들어갈 경우")
    @Test
    public void construct_null() throws Exception {
        //given
        DelimiterStrategy strategy = new DelimiterStrategy(" ,2,,2", ",");

        //then
        assertThat(strategy.getOperands().getOperands().size()).isEqualTo(4);
    }

    @DisplayName("생성자 테스트 : fail")
    @Test
    public void construct_fail() throws Exception {
        //given
        DelimiterStrategy strategy1 = new DelimiterStrategy("1:1", ":");
        DelimiterStrategy strategy2 = new DelimiterStrategy("1:2", ":");

        //then
        assertThat(!strategy1.equals(strategy2)).isTrue();
    }

    @DisplayName("피연산자 테스트 : null이 입력 됐을때")
    @Test
    public void operand() throws Exception {
        //given
        DelimiterStrategy strategy = new DelimiterStrategy(null, ":");

        //then
        assertAll(
                () -> assertThat(strategy.getOperands().getOperands().size()).isEqualTo(1),
                () -> assertThat(strategy.getOperands().getOperands().get(0).getOperand()).isEqualTo(0)
        );
    }
}

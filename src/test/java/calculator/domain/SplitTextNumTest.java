package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SplitTextNumTest {
    @Test
    void create() {
        Assertions.assertThat(new SplitTextNum(new String[]{"10","20","10"})).isEqualToComparingFieldByField(new SplitTextNum(new String[]{"10","20","10"}));
    }

    @Test
    void sum() {
        Assertions.assertThat(new SplitTextNum(new String[]{"10","20","10"}).sum()).isEqualToComparingFieldByField(new SplitTextNum(new String[]{"40"}).sum());
    }

}
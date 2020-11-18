package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberCountTest {

    @DisplayName("특정 수가 몇개 있는지를 가지는 객체를 생성")
    @Test
    public void test_NumberCount_Constructor() {
        assertThat(NumberCount.of(0, 10)).isEqualTo(NumberCount.of(0, 10));
    }
}

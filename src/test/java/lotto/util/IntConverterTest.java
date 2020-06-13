package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntConverterTest {

    @DisplayName("string 을 int로 정상적으로 변환한다.")
    @Test
    public void fromStringTest() {
        assertThat(IntConverter.from("1")).isEqualTo(1);
    }

    @DisplayName("string 이 숫자 형태가 아닐 때 IllegalArgumentException 이 발생한다.")
    @Test
    public void fromNoNumberFormatTest() {
        assertThatThrownBy(()->{
            IntConverter.from("#1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("string 리스트를 변환 시 숫자 형태가 아닐 때 IllegalArgumentException 이 발생한다.")
    @Test
    public void fromStringListTest() {
        assertThat(IntConverter.from(List.of("1","2","3"))).containsOnly(1,2,3);
    }

    @DisplayName("string 리스트를 int리스트로 정상적으로 변환한다.")
    @Test
    public void fromStringListNoNumberFormatTest() {
        assertThatThrownBy(()->{
            IntConverter.from(List.of("1","^2","3"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
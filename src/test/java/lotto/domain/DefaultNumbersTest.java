package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultNumbersTest {

    @Test
    @DisplayName("1부터 45까지인 list가 생성된다.")
    void default_list_test(){
        DefaultNumbers defaultNumbers = new DefaultNumbers();
        assertThat(defaultNumbers.of().size()).isEqualTo(45);
    }
}

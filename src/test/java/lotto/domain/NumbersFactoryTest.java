package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersFactoryTest {

    @DisplayName("중복되지 않은 숫자들을 얻을 수 있다.")
    @Test
    void canCreateNonDuplicateNumbers() {
        assertThat(NumbersFactory.createNonDuplicateNumbers()).isNotNull();
    }
}

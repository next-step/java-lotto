package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersFactoryTest {

    @DisplayName("중복되지 않은 숫자들을 얻을 수 있다.")
    @Test
    void canCreateNonDuplicateNumbers() {
        List<Integer> nonDuplicateNumbers = NumbersFactory.createNonDuplicateNumbers(6);
        assertThat(nonDuplicateNumbers).isNotNull();

        Set<Integer> set = new HashSet<>(nonDuplicateNumbers);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(set.size());
    }
}

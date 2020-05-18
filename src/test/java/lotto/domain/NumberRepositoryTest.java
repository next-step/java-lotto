package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberRepositoryTest {

    @DisplayName("6개의 숫자들을 얻을 수 있다.")
    @Test
    void canGet_6_Numbers() {
        assertThat(NumberRepository.createNonDuplicateNumbers()).hasSize(6);
    }

    @DisplayName("6개의 숫자들은 중복되지 않는다.")
    @Test
    void nonDuplicateNumbers() {
        List<Integer> nonDuplicateNumbers = NumberRepository.createNonDuplicateNumbers();
        Set<Integer> set = new HashSet<>(nonDuplicateNumbers);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(set.size());
    }
}

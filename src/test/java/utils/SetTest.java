package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set Collection 의 중복이제거된 크기 확인 테스트")
    @Test
    public void setCollectionSizeCheckTest() {
        int size = numbers.size();

        assertThat(numbers).hasSize(size);
        assertThat(numbers.size()).isEqualTo(size);
    }

}

package kr.aterilio.nextstep.techcamp.m1.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("size numbers -> expected 3")
    @Test
    public void testReq1_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contain numbers using ValueSource -> expected 1:true, 2:true, 3:true")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void testReq2_containValueSource(int target) {
        assertThat(numbers.contains(target)).isTrue();
    }

    @DisplayName("contain numbers using CsvSource -> expected 1:true, 2:true, 3:true, 4:false, 5:false")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void testReq3_containCsvSource(int target, boolean isContain) {
        assertThat(numbers.contains(target)).isEqualTo(isContain);
    }
}

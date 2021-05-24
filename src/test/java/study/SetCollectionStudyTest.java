package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionStudyTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    @DisplayName("요구사항 1. Set size() 메소드를 활용해, Set의 크기를 확인")
    public void getSetSize_green(){
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2. Set contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    public void isContain_green(int aValue){
        assertThat(numbers.contains(aValue))
                .isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("요구사항 3. Set contains() 메소드를 활용해 4,5 의 값이 존재하지 않는지를 확인")
    public void isContain_red(int notAValue){
        assertThat(numbers.contains(notAValue))
                .isFalse();
    }
}
package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("Set의 Size를 활용해 Set의 크기를 확인한다")
    void size() {
        assertThat(this.numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains를 활용해 값의 존재여부를 확인한다")
    void contains(int num) {
        assertTrue(this.numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set의 contains를 CsvSource를 사용하여 확인한다.")
    void containsWithDelimiter(String num,String reference){
        if(Boolean.valueOf(reference)){
            assertTrue(this.numbers.contains(Integer.valueOf(num)));
        }else{
            assertFalse(this.numbers.contains(Integer.valueOf(num)));
        }
    }
}


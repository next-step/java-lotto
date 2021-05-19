import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("Set.size, numbers 객체의 size 확인")
    void sizeOfGiven() {
        // Given
        int expectedResult = 3;

        // When
        int actualResult = numbers.size();

        // Then
        assertEquals(expectedResult, actualResult);
    }
}

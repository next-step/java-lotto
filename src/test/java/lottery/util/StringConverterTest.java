package lottery.util;

import lottery.domain.WinLottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConverterTest {

    @Test
    @DisplayName("Set<Intger> 변환 테스트")
    void convertToIntegerSetTest(){
        // Given
        final String input = "1, 2, 3, 4, 5, 6";

        // When
        Set<Integer> actual = StringConverter.convertToIntegerSet(input);
        
        // Then
        assertThat(actual).hasSize(6);
        assertThat(actual).contains(1, 2, 3, 4, 5, 6);
    }
}

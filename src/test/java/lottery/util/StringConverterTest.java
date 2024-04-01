package lottery.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConverterTest {

    @Test
    @DisplayName("Set<Intger> 변환 테스트")
    void convertToIntegerSetTest(){
        final Set<Integer> actual = StringConverter.convertToIntegerSet("1, 2, 3, 4, 5, 6");
        
        assertThat(actual).hasSize(6);
        assertThat(actual).contains(1, 2, 3, 4, 5, 6);
    }
}

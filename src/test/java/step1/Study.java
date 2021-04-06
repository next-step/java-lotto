package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Study {
    @Test
    @DisplayName("배열을 정수형 리스트로 변환하는지 테스트")
    void listConvertedFromArray(){
        // given
        List<String> given = Arrays.asList("1","3","5");

        List<Integer> expected = Arrays.asList(1, 3, 5);
        List<Integer> actual = new ArrayList<>();

        // when
        for (String s : given) {
            actual.add(Integer.parseInt(s));
        }

        // then
        assertEquals(expected, actual);
    }
}

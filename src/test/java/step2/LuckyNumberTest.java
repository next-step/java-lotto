package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 입력받은_당첨번호로_당첨번호_일급컬렉션을_생성한다(int index) {
        //Given
        List<Integer> testLuckyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        LuckyNumber luckyNumber = LuckyNumber.from(testLuckyNumber);

        //When
        //Then
        assertThat(luckyNumber.getLuckyNumber().get(index).getNumber())
                .isEqualTo(testLuckyNumber.get(index));
    }
}

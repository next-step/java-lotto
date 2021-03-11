package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveNumberTest {

    private final PositiveNumber positiveNumber;

    public PositiveNumberTest() {
        this.positiveNumber = new PositiveNumber();
    }

    @DisplayName("숫자 변환 테스트")
    @Test
    void toInt(){
        //given
        String [] stringNumbers = {"1","2","3","4"};

        //when
        List<Integer> numbers= positiveNumber.toInt(stringNumbers);

        //then
        assertThat(numbers).contains(1,2,3,4);
    }

    @DisplayName("더하기 테스트")
    @Test
    void add(){
        //given
        List<Integer> numbers = List.of(1,2,3,4,5);

        //when
        int result = positiveNumber.add(numbers);

        //then
        assertThat(result).isEqualTo(15);
    }

}
package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Numbers;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import org.assertj.core.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    @DisplayName("numbers 의 원소인 number 들의 number 값을 전부 합한 값 return 테스트")
    void addTest() {
        List<Integer> numberList = new ArrayList<Integer>();
        numberList.add(100);
        numberList.add(17);
        Numbers numbers = new Numbers(numberList);
        assertThat(numbers.add().getNum()).isEqualTo(117);
    }
}

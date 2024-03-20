package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoViewTest {

    @Test
    void split() {
        String result = "1, 2, 3, 4, 5, 6";
        String[] split = result.split(", ");
        Arrays.stream(split).forEach(item -> System.out.println(item));
    }

    @Test
    void name() {
        String result = "teest" + String.format("%.2f", 5000 / (double) 14000) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    }
}

package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.RandomNumbers;
import step2.domain.RandomNumbersList;

import java.util.List;

public class RandomNumbersTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열이 잘 생성되는지 확인")
    void randomNumbersTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Integer> randomNumberList = randomNumbers.getRandomNumbers();
        System.out.println(randomNumberList);
    }


}

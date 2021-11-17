package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.RandomNumbers;
import step2.domain.RandomNumbersList;

import java.util.List;

public class RandomNumbersListTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열의 배열이 잘 생성되는지 확인")
    void randomNumbersListTest() {
        RandomNumbersList randomNumbersList = new RandomNumbersList(5);
        List<RandomNumbers> randomNumberList = randomNumbersList.getRandomNumbersList();
        randomNumberList.stream().map(RandomNumbers->RandomNumbers.getRandomNumbers()).forEach(System.out::println);
    }
}

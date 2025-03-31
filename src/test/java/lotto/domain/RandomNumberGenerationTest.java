package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class RandomNumberGenerationTest {

    @Test
    @DisplayName("6개의 서로 다른 번호를 생성한다")
    void generateNumbersTest() {
        //given
        RandomNumberGeneration randomNumberGeneration = new RandomNumberGeneration();

        //when
        Set<Integer> numberSet = new HashSet<>(randomNumberGeneration.generateNumbers());

        //then
        Assertions.assertThat(numberSet).hasSize(6);
    }

}
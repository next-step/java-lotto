package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomLottoGenerationTest {

    @Test
    void name() {
        RandomLottoGeneration randomLottoGeneration = new RandomLottoGeneration();
        List<Integer> generate = randomLottoGeneration.generate();
        System.out.println("generate >> "+  generate);
    }
}

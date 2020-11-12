package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomLottoGeneratorTest {
    @Test
    void name() {
        List<Integer> integers = RandomLottoGenerator.generateLottoNumbers();
        integers.forEach(integer -> {
            System.out.println("integer = " + integer);
        });
    }
}
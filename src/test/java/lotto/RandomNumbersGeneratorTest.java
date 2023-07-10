package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersGeneratorTest {

    @Test
    void 싱글톤객체인_RandomNumberGenerator객체_반환_성공() {
        // given, when, then
        assertDoesNotThrow(RandomNumbersGenerator::getInstance);
    }
}

package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class NumberGenerationTest {

    @DisplayName("로또 1~45 번호 생성 테스트")
    @Test
    void getLottoAllNumberInRangeTest() {
        List<Integer> expectedLottoAllNumberInRange = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> lottoAllNumberInRange = NumberGeneration.getLottoAllNumberInRange();
        assertEquals(expectedLottoAllNumberInRange, lottoAllNumberInRange);
    }

}
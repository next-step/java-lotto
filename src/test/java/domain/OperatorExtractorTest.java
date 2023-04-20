package domain;

import domain.extractor.Extractor;
import domain.extractor.OperatorExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OperatorExtractorTest {

    private Extractor<?> extractor;

    @BeforeEach
    void initialization() {
        extractor = new OperatorExtractor();
    }

    @Test
    @DisplayName("연산자를 추출하는 테스트")
    void extract() {

        List<String> input = List.of("2", "+", "3", "*", "4", "2");

        extractor.extract(input);
    }
}
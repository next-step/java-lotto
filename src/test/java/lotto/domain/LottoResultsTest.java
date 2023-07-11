package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @Test
    @DisplayName("로또 결과 생성 테스트")
    void lottoResults_create() {
        /* given & when & then */
        assertDoesNotThrow(() -> new LottoResults(List.of(
                new LottoResult(1, false),
                new LottoResult(6, true)))
        );
    }
}

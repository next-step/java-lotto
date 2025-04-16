package step3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Lotto;
import step3.domain.LottoNumbers;

public class LottoTest {
    @Test
    @DisplayName("로또 번호 비교 로직 테스트")
    public void compareTest() {
        LottoNumbers source = LottoNumbers.organized(
            List.of(1, 2, 3, 4, 5, 6)
        );
        LottoNumbers target = LottoNumbers.organized(
            List.of(1, 2, 3, 4, 5, 7)
        );
        Lotto sourceLotto = new Lotto(source);
        assertEquals(5, sourceLotto.matchCount(target));
    }
}

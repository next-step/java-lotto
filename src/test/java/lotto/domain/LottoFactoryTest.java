package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoFactoryTest {

    @Test
    @DisplayName("개수만큼 자동으로 로또가 생성되는지 확인")
    void generateLotto() {
        List<LottoNumbers> numbers = LottoFactory.generateLotto(3);
        assertEquals(numbers.size(), 3);
    }
}

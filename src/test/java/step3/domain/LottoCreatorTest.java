package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoCreatorTest {

    @DisplayName("매 실행 시마다 무작위 번호를 갖는 로또 생성기 정상 작동 테스트")
    @Test
    void success() {
        assertDoesNotThrow(LottoCreator::create);
    }
}

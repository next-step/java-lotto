package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("랜덤한 로또번호를 생성합니다.")
    @Test
    void createLotto() {
        Lotto lotto = NumberGenerator.getLotto();

    }
}
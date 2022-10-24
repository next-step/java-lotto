package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Lotto;

class RandomLottoGeneratorTest {

    private RandomLottoGenerator randomLottoGenerator;

    private static final int LOTTO_SIZE = 6;

    @BeforeEach
    void setUp() {
        randomLottoGenerator = new RandomLottoGenerator();
    }

    @Test
    @DisplayName("로또번호 6자리가 생성되었는지 확인")
    void 로또번호_6_자리가_생성되었는지_확인() {

        Lotto createRandomLotto = randomLottoGenerator.createRandomLotto();

        assertThat(createRandomLotto.getLotto().size()).isEqualTo(LOTTO_SIZE);

    }

}
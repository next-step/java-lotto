package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void lotto_generate_size() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generate()).hasSize(6);
    }

    @Test
    void lotto_bonus_no_test() {
        Lotto lotto = Lotto.ofWinningLotto("1,2,3,4,5,6");
        LottoGenerator lottoGenerator = new LottoGenerator();
        int bonus = lottoGenerator.generateBonusNo(lotto);
        assertThat(lotto.getLottoNumber()).doesNotContain(bonus);
    }
}
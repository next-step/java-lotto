package model;

import generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("금액/1000한 숫자만큼 로또를 발급해준다.")
    void generateLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        assertThat(lottoShop.generateLotto(14000)).hasSize(14);
    }
}
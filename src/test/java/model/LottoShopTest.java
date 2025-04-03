package model;

import generator.RandomNumberGenerator;
import model.lotto.LottoShop;
import model.lotto.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoShopTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    @Test
    @DisplayName("금액/1000한 숫자만큼 로또를 발급해준다.")
    void generateLotto() {
        Price price = new Price(14000);
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        assertEquals(lottoShop.generateLotto(price).getTotalLottoCounts(), 14);
    }

    @Test
    @DisplayName("금액이 1000원 미만이면 에러를 반환한다.")
    public void generateLottoException() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        Price price = new Price(100);
        assertThatThrownBy(() -> lottoShop.generateLotto(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
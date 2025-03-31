package model;

import generator.RandomNumberGenerator;
import model.lotto.LottoCount;
import model.lotto.LottoShop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @Test
    @DisplayName("금액/1000한 숫자만큼 로또를 발급해준다.")
    void generateLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        assertThat(lottoShop.generateLotto(new LottoCount(14000, 14), new ArrayList<>())).hasSize(14);
    }

    @Test
    @DisplayName("금액이 1000원 미만이면 에러를 반환한다.")
    public void generateLottoException() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        assertThatThrownBy(() -> lottoShop.generateLotto(new LottoCount(100, 1), new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
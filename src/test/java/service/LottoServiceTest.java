package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    public void gameCountTest() {
        int purchasePrice = 10_000;
        int expected = 10;
        int size = lottoService.create(purchasePrice).count();
        assertThat(size).isEqualTo(expected);
    }

    @Test
    public void purchasePriceNegativeTest() {
        int purchasePrice = -1_000;
        assertThatThrownBy(() -> lottoService.create(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void purchasePriceNotEnoughTest() {
        int purchasePrice = 10_600;
        assertThatThrownBy(() -> lottoService.create(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }



}

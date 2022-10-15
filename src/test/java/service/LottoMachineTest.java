package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.LottoNumbers;
import domain.Money;

class LottoMachineTest {

    private static final int LOTTO_PRICE = 1000;

    private Money purchaseMoney;

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();

        purchaseMoney = Money.from(2000);
    }

    @Test
    @DisplayName("로또가 갯수에 맞게 구입되었는지 확인하는 테스트")
    void 로또가_갯수에_맞게_구입되었는지_확인하는_테스트() {

        LottoNumbers purchaseLotto = lottoMachine.purchaseLotto(purchaseMoney);

        assertThat(purchaseLotto.getLottoNumbers().size()).isEqualTo(purchaseMoney.getMoney() / LOTTO_PRICE);

    }
}
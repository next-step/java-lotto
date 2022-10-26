package service;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Lotto;
import domain.Lottos;
import domain.Money;

class LottoGenerator1Test {

    private static final int LOTTO_PRICE = 1000;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 45;

    private Money purchaseMoney;

    private LottoIssueMachine lottoIssueMachine;

    private RandomLottoGenerator randomLottoGenerator;


    @BeforeEach
    void setUp() {

        randomLottoGenerator = new RandomLottoGenerator();

        lottoIssueMachine = new LottoIssueMachine(randomLottoGenerator);

        purchaseMoney = Money.from(2000);
    }

    @Test
    @DisplayName("로또가 갯수에 맞게 구입되었는지 확인하는 테스트")
    void 로또가_갯수에_맞게_구입되었는지_확인하는_테스트() {

        Lottos purchaseLotto = lottoIssueMachine.purchaseLotto(purchaseMoney);

        assertThat(purchaseLotto.getLottoNumbers().size()).isEqualTo(purchaseMoney.getMoney() / LOTTO_PRICE);

    }

    @Test
    @DisplayName("로또가 1, 45 사이의 범위내에서 제대로 생성되었는지 테스트")
    void 로또가_허용_생성_범위내에서_제대로_생성되었는지_테스트() {

        Lotto randomLotto = randomLottoGenerator.createRandomLotto();

        randomLotto.getLotto().sort(Comparator.naturalOrder());

        assertThat(randomLotto.getLotto().get(0)).isGreaterThanOrEqualTo(MIN_NUMBER);
        assertThat(randomLotto.getLotto().get(5)).isLessThanOrEqualTo(MAX_NUMBER);

    }
}
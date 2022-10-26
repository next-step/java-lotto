package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Lottos;
import domain.Money;

class LottoIssueMachineTest {

    private RandomLottoGenerator randomLottoGenerator;
    private LottoIssueMachine lottoIssueMachine;

    @BeforeEach
    void setUp() {
        randomLottoGenerator = new RandomLottoGenerator();
        lottoIssueMachine = new LottoIssueMachine(randomLottoGenerator);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3"}, delimiter = ':')
    @DisplayName("로또가 기대갯수만큼 구매되었는지 확인하는 테스트")
    void 로또가_기대갯수만큼_구매되었는지_확인하는_테스트(int money, int count) {

        Money purchaseMoney = Money.from(money);

        Lottos createLottos = lottoIssueMachine.purchaseLotto(purchaseMoney);

        assertThat(createLottos.getLottoNumbers().size()).isEqualTo(count);

    }

}
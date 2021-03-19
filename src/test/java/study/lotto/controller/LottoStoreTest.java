package study.lotto.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.generator.ManualLottoNumberGenerator;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @ParameterizedTest(name = "{0} 금액 입력 시 로또 {1} 세트 출력 테스트")
    @CsvSource(value = {"1000, 1", "2000, 2"})
    void lotto_금액_지불_및_로또_반환(int given, int expected) {
        // given
        LottoStore lottoStore = new LottoStore();

        // when
        Lottos lottos = lottoStore.lotto(new RequestMoney(given, 0), new Lottos(new ArrayList<>()));
        List<Lotto> lotteries = lottos.lottoList();
        // then
        assertThat(lotteries.size()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 수동 숫자 생성 {1} 세트 출력 테스트")
    @CsvSource(value = {"1,2,3,4,5,6:1", "3,4,5,6,7,8:3"}, delimiter = ':')
    void manualLotto_숫자_생성_테스트(String given, int expected) {
        // given
        LottoStore lottoStore = new LottoStore(new ManualLottoNumberGenerator());
        // when
        Lotto lotto = lottoStore.manualLotto(given);
        LottoNumber bonusNumber = new LottoNumber(expected);
        boolean contains = lotto.contains(bonusNumber);
        // then
        assertThat(contains).isTrue();
    }
}

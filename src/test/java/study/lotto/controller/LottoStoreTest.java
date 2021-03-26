package study.lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.Money;
import study.lotto.service.Lottos;
import study.lotto.view.dto.ManualLottoParser;
import study.lotto.view.dto.RequestLottoArgument;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("금액 1000원 입력 수동 번호 입력 시 총 로또 몇개인지 테스트")
    @Test
    void lotto_금액_지불_및_로또_반환() {
        // given
        LottoStore lottoStore = new LottoStore();

        // when
        RequestLottoArgument lottoArgument = RequestLottoArgument.of(Money.of(1000), "1");

        List<Set<Integer>> lotto = Arrays.asList(
                IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toSet()));
        ManualLottoParser manualLottoParser = ManualLottoParser.of(lotto);

        Lottos lottos = lottoStore.issueLotto(lottoArgument, manualLottoParser);
        List<Lotto> lotteries = lottos.lottoList();

        // then
        assertThat(lotteries.size()).isEqualTo(1);
    }
}

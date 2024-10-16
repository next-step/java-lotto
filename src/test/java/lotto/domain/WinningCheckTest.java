package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoGenerator.lottoGenerator;

public class WinningCheckTest {

    private final Lotto lottoHitAll = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFive = new Lotto(IntStream.rangeClosed(2, 7)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    @Test
    @DisplayName("로또 금액 여부를 확인한다")
    void 로또_당첨_금액_확인() {
        Lottos lottos = Lottos.createLottos(1000, purchaseAmount -> List.of(new Lotto(lottoGenerator.subList(0, LottoGenerator.LOTTO_SIZE))));

        Assertions.assertThat(lottos.getWinningPrize(lottoHitAll)).isEqualTo(2_000_000_000);

    }

    @Test
    @DisplayName("1등 2번 당첨된 경우 오버플로 발생하여 음수가 되는지 확인")
    void 로또_당첨_오버플로() {

        Lottos lottos = Lottos.createLottos(2000, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThatThrownBy(
                        () -> lottos.getWinningPrize(lottoHitAll)
                ).isInstanceOf(PrizeOverFlowIsNegativeException.class)
                .hasMessage("당첨금 계산 중 오버플로 발생");

    }

    @Test
    @DisplayName("1등 ,3등에 당첨되었을 때 총 상금을 초과하는지 확인")
    void 로또_상금_초과() {

        Lottos lottos = Lottos.createLottos(2000, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitFive);

        Assertions.assertThatThrownBy(
                        () -> lottos.getWinningPrize(lottoHitAll)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 상금 20억을 넘길 순 없음");

    }

}

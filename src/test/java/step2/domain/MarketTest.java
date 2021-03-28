package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {

    @DisplayName("getLottos 테스트 - 정상적으로 로또번호가 생성 됬을경우 테스트")
    @Test
    void marketGetLottosTest() {

        List<Integer> firstNumbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toList());

        List<Integer> secondNumbers =
                Stream.of(1, 2, 3, 4, 5, 7)
                        .collect(Collectors.toList());

        List<Integer> thirdNumber =
                Stream.of(1, 2, 3, 4, 5, 8)
                        .collect(Collectors.toList());

        List<List<Integer>> numbers =
                Arrays.asList(
                        firstNumbers, secondNumbers, thirdNumber);

        List<LottoNumberGenerator> lottoNumberGenerators = Arrays.asList(
                new LottoFixedLottoNumberGenerator(firstNumbers),
                new LottoFixedLottoNumberGenerator(secondNumbers),
                new LottoFixedLottoNumberGenerator(thirdNumber));

        Market market = new Market(3000, numbers);
        Lottos lottosByMarket = market.getLottos();
        Lottos lottos = new Lottos(lottoNumberGenerators);


        Assertions.assertEquals(lottos, lottosByMarket);
    }

    @DisplayName("getLottos 테스트 - 정상적으로 로또번호가 안됬을 경우 테스트")
    @Test
    void marketGetLottosFalseTest() {

        List<Integer> firstNumbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toList());

        List<Integer> secondNumbers =
                Stream.of(1, 2, 3, 4, 5, 7)
                        .collect(Collectors.toList());

        List<Integer> thirdNumber =
                Stream.of(1, 2, 3, 4, 5, 8)
                        .collect(Collectors.toList());

        List<List<Integer>> numbers =
                Arrays.asList(
                        firstNumbers, secondNumbers, thirdNumber);

        List<LottoNumberGenerator> lottoNumberGenerators = Arrays.asList(
                new LottoFixedLottoNumberGenerator(firstNumbers),
                new LottoFixedLottoNumberGenerator(secondNumbers),
                new LottoFixedLottoNumberGenerator(thirdNumber));

        Market market = new Market(4000, numbers);
        Lottos lottosByMarket = market.getLottos();
        Lottos lottos = new Lottos(lottoNumberGenerators);


        Assertions.assertNotEquals(lottos, lottosByMarket);
    }

}
package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {


    @DisplayName("특정 index에 해당하는 Lotto 숫자를 반환하는 테스트")
    @Test
    public void indexGetLotto() {

        //Given
        Lottos lottos = new Lottos();
        lottos.addLotto(Lotto.of(new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10))));
        lottos.addLotto(Lotto.of(new HashSet<>(Arrays.asList(2, 3, 5, 7, 9, 11))));
        lottos.addLotto(Lotto.of(new HashSet<>(Arrays.asList(10, 15, 16, 17, 18, 20))));


        //When
        Set<LottoNumber> result = lottos.getLotto(2);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).contains(LottoNumber.from(10), LottoNumber.from(15), LottoNumber.from(16));

    }


    @DisplayName("당첨번호 확인 후 Reward 인스턴스 생성 여부 테스트")
    @Test
    public void matchPrizeNumberTest() {

        //Given
        Lottos lottos = new Lottos();
        lottos.addLotto(Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 9))));

        //When
        Reward reward = lottos.matchPrizeNumber(new PrizeLotto(Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 9))), 5));

        //Then
        assertThat(reward).isNotNull();
        assertThat(reward.getRewardResult().get(PrizeInformation.FIRST)).isNotNull();

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 7, 8})
    public void addLottos(int quantity) {
        //Given
        Lottos lottos = new Lottos();

        //When
        IntStream.range(0, quantity)
                .forEach(i -> lottos.addLotto(Lotto.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));


        //Then
        assertThat(lottos.quantity()).isEqualTo(quantity);
    }

    @ParameterizedTest
    @MethodSource("createManualLottos")
    public void addManualLottosTest(List<Lotto> manualLottos) {
        //Given
        Lottos lottos = new Lottos();

        //When
        lottos.addManualLottos(manualLottos);

        //Then
        assertThat(lottos.quantity()).isEqualTo(manualLottos.size());
    }

    private static Stream<Arguments> createManualLottos() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Lotto.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 30, 23, 6))),
                        Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 30, 15, 40)))
                )
        );
    }

}
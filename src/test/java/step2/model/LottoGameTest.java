package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.LottoOutOfSelfLottoException;
import step2.util.LottoMakeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1005:1", "4800:4", "7900:7", "50400:50"}, delimiter = ':')
    @DisplayName("입력한 금액 대비 구입할수 있는 개수")
    void 입력한_금액_대비_개수(int money, int result) {
        LottoGame lottoGame = new LottoGame(new LottoMoney(money), Lottos.of(new ArrayList<>()));
        assertThat(lottoGame.getLottoRandomCount()).isEqualTo(result);
    }

    @DisplayName("입력한 금액 대비 수 구입할수 있는 개수")
    @ParameterizedTest
    @MethodSource("provideLottoGameParameter")
    void 셀프_랜덤_대비_개수(int money, Lottos lottosSelf, int resultRandom, int resultSelf) {
        LottoGame lottoGame = new LottoGame(new LottoMoney(money), lottosSelf);

        assertThat(lottoGame.getLottoRandomCount()).isEqualTo(resultRandom);
        assertThat(lottoGame.getLottoSelfCount()).isEqualTo(resultSelf);
    }

    private static Stream<Arguments> provideLottoGameParameter() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")));

        List<Lotto> lottoList2 = new ArrayList<>();

        List<Lotto> lottoList3 = new ArrayList<>();
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,8")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,9")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,10")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,11")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,12")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,13")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,14")));
        lottoList3.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,15")));

        return Stream.of(
                Arguments.of(10000, Lottos.of(lottoList), 8, 2)
                , Arguments.of(10000, Lottos.of(lottoList2), 10, 0)
                , Arguments.of(10000, Lottos.of(lottoList3), 0, 10)
        );
    }

    @DisplayName("입력한 금액 대비 수동 구입할수 있는 개수가 넘었을 때")
    @ParameterizedTest
    @MethodSource("provideOverLottoGameParameter")
    void 셀프_랜덤_대비_개수가_넘었을(int money, Lottos lottosSelf) {
        assertThatExceptionOfType(LottoOutOfSelfLottoException.class).isThrownBy(() -> new LottoGame(new LottoMoney(money), lottosSelf));
    }

    private static Stream<Arguments> provideOverLottoGameParameter() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")));

        return Stream.of(
                Arguments.of(1000, Lottos.of(lottoList))
        );
    }
}

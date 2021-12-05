package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
@Nested
@DisplayName("Lottos 클래스는")
public class LottosTest {
    private static Stream<Arguments> generateGetPrizeTestArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("11,12,13,14,15,16"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,13,44,45,36"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("21,12,33,1,2,3"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,12,13,44,45,36"));
        Lottos lottos = Lottos.ofLottos(lottoList);
        LottoNumber bonus = LottoNumber.ofInt(10);
        listOfArguments.add(Arguments.of(lottos, bonus, 2_000_000_000 + 5_000));

        List<Lotto> lottoList1 = new ArrayList<>();
        lottoList1.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        lottoList1.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        lottoList1.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,7"));
        Lottos lottos1 = Lottos.ofLottos(lottoList1);
        LottoNumber bonus1 = LottoNumber.ofInt(7);
        listOfArguments.add(Arguments.of(lottos1, bonus1, 2_000_000_000 * 2 + 30000000));

        List<Lotto> lottoList2 = new ArrayList<>();
        lottoList2.add(Lotto.ofManualStringLottoNumbers("1,2,3,14,15,16"));
        lottoList2.add(Lotto.ofManualStringLottoNumbers("11,12,13,4,5,6"));
        lottoList2.add(Lotto.ofManualStringLottoNumbers("1,2,3,14,5,7"));
        Lottos lottos2 = Lottos.ofLottos(lottoList2);
        LottoNumber bonus2 = LottoNumber.ofInt(7);
        listOfArguments.add(Arguments.of(lottos2, bonus2, 5_000 * 2 + 50_000));

        return listOfArguments.stream();
    }

    @ParameterizedTest
    @MethodSource("generateGetPrizeTestArgumentsStream")
    @DisplayName("lottos 의 getPrize 테스트")
    void getPrizeTest(Lottos lottos, LottoNumber bonus, int expect) {
        WinningLotto winningNumber = WinningLotto.ofStringAndBonusBall("1,2,3,4,5,6", bonus);
        assertThat(lottos.getTotalProfit(winningNumber, bonus)).isEqualTo(expect);
    }

    @Test
    @DisplayName("특정 상금을 몇번 받았는지 getCountTest")
    void getCountTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,22,3,14,15,6"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,14,15,16"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,12,13,14,15,17"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,22,23,24,5,27"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,7"));
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,11,7"));

        Lottos lottos = Lottos.ofLottos(lottoList);
        LottoNumber bonus = LottoNumber.ofInt(7);
        WinningLotto winningNumber = WinningLotto.ofStringAndBonusBall("1,2,3,4,5,6", bonus);


        assertThat(lottos.getCount(Prize.FIRST, winningNumber, bonus)).isEqualTo(1);
        assertThat(lottos.getCount(Prize.SECOND, winningNumber, bonus)).isEqualTo(1);
        assertThat(lottos.getCount(Prize.THIRD, winningNumber, bonus)).isEqualTo(0);
        assertThat(lottos.getCount(Prize.FOURTH, winningNumber, bonus)).isEqualTo(1);
        assertThat(lottos.getCount(Prize.FIFTH, winningNumber, bonus)).isEqualTo(2);
        assertThat(lottos.getCount(Prize.ELSE, winningNumber, bonus)).isEqualTo(2);


    }

    @Test
    @DisplayName("Lottos merge test")
    void mergeLottosTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        Lottos lottos1 = Lottos.ofLottos(lottoList);

        List<Lotto> lottoList_2 = new ArrayList<>();
        lottoList_2.add(Lotto.ofManualStringLottoNumbers("11,12,13,14,15,16"));
        Lottos lottos2 = Lottos.ofLottos(lottoList_2);

        lottos1.mergeLottos(lottos2);

        List<Lotto> expectList = new ArrayList<>();
        expectList.add(Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6"));
        expectList.add(Lotto.ofManualStringLottoNumbers("11,12,13,14,15,16"));

        Lottos lottos = Lottos.ofLottos(expectList);
        assertThat(lottos1.getLottos()).isEqualTo(lottos.getLottos());
    }
}

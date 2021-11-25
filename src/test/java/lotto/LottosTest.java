package lotto;

import lotto.domain.*;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LottosTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,4,5,6"));
        lottoList.add(new Lotto("11,12,13,14,15,16"));
        lottoList.add(new Lotto("1,2,13,44,45,36"));
        lottoList.add(new Lotto("21,12,33,1,2,3"));
        lottoList.add(new Lotto("1,12,13,44,45,36"));
        Lottos lottos = new Lottos(lottoList);
        LottoNumber bonus = new LottoNumber(10);
        listOfArguments.add(Arguments.of(lottos, bonus, 2_000_000_000 + 5_000));

        List<Lotto> lottoList1 = new ArrayList<>();
        lottoList1.add(new Lotto("1,2,3,4,5,6"));
        lottoList1.add(new Lotto("1,2,3,4,5,6"));
        lottoList1.add(new Lotto("1,2,3,4,5,7"));
        Lottos lottos1 = new Lottos(lottoList1);
        LottoNumber bonus1 = new LottoNumber(7);
        listOfArguments.add(Arguments.of(lottos1, bonus1, 2000000000 * 2 + 30000000));

        List<Lotto> lottoList2 = new ArrayList<>();
        lottoList2.add(new Lotto("1,2,3,14,15,16"));
        lottoList2.add(new Lotto("11,12,13,4,5,6"));
        lottoList2.add(new Lotto("1,2,3,14,5,7"));
        Lottos lottos2 = new Lottos(lottoList2);
        LottoNumber bonus2 = new LottoNumber(7);
        listOfArguments.add(Arguments.of(lottos2, bonus2, 5_000 * 2 + 50_000));

        return listOfArguments.stream();
    }

    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("lottos 의 getPrize 테스트")
    void getPrizeTest(Lottos lottos, LottoNumber bonus, Integer expect) {
        WinningLotto winningNumber = new WinningLotto("1,2,3,4,5,6", bonus);
        assertThat(lottos.getPrize(winningNumber, bonus)).isEqualTo(expect);
    }

    @Test
    @DisplayName("당첨 번호를 얼마나 맞췄는지 getCountTest")
    void getCountTest() {
        WinningLotto winningNumber = new WinningLotto("1,2,3,4,5,6", new LottoNumber(13));
        LottoNumber bonus = new LottoNumber(10);
        Lottos lottos = new Lottos(7000,
                () -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        assertThat(lottos.getCount(Prize.FIFTH, winningNumber, bonus)).isEqualTo(7);
    }

}

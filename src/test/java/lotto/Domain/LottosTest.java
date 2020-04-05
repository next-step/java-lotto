package lotto.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottosTest {

    @Test
    void matchTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 13, 4, 5, 6);
        Lotto lotto = Lotto.init(lottoNumbers);
        List<Lotto> lottoList = Arrays.asList(lotto, lotto);
        Lottos lottos = Lottos.init(lottoList);

        int bonus = 7;
        Lotto winlotto = Lotto.init(new ArrayList<>(Arrays.asList(1, 2, 13, 24, 35, 42)));
        WinningLotto winningNumber = WinningLotto.init(winlotto, bonus);

        LottoResult matchCountMap = lottos.match(winningNumber);

        assertThat(matchCountMap.winLottoGradeAndPrize())
                .contains(entry(LottoGrade.MISS, 0)
                        , entry(LottoGrade.WIN5TH, 2)
                        , entry(LottoGrade.WIN4TH, 0)
                        , entry(LottoGrade.WIN3RD, 0)
                        , entry(LottoGrade.WIN2ND, 0)
                        , entry(LottoGrade.WIN1ST, 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 13 4 5 6:5", "13 24 1 5 42 7:50", "1 2 13 35 24 42:2000000"}, delimiter = ':')
    void statisticsTest(String input, String expected) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Lotto lotto = Lotto.init(lottoNumbers);
        Lottos lottos = Lottos.init(new ArrayList<>());
        lottos.add(lotto);


        int bonus = 7;
        Lotto winlotto = Lotto.init(new ArrayList<>(Arrays.asList(1, 2, 13, 24, 35, 42)));
        WinningLotto winningNumber = WinningLotto.init(winlotto, bonus);

        LottoResult statistics = lottos.match(winningNumber);
        Double revenueRate = statistics.revenueRate();

        assertThat(revenueRate).isEqualTo(Double.parseDouble(expected));
    }
}

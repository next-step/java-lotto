package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.RankDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("Prize_테스트")
    @Test
    void getPrizeTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto lotto_two = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto lotto_three = new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        List<Lotto> lotttos = new ArrayList<>();

        lotttos.add(lotto);
        lotttos.add(lotto_two);
        lotttos.add(lotto_three);

        Prize prize = new Prize(new Money(14000));
        Winning winning = new Winning("1,2,3,4,5,6", new LottoNumber("7"));
        RankResult rankResult = new RankResult(lotttos, winning);
        RankDTO rankDto = new RankDTO(rankResult, prize);

        assertThat(
            Math.round(prize.getPrizeRatio(rankResult, new Money(14000)) * 100) / 100.0).isEqualTo(
            14285.71);
    }
}
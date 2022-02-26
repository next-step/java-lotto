package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCountTest {

    private static final int size = 14;

    @DisplayName("로또_등수가_체크되는지_확인")
    @Test
    void lottoRankTest() {
        List<Lotto> lottos = LottoGenerator.lottoBundle(new ArrayList<>(), size);

        Lotto lotto = new Lotto(
            Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        LottoNumber bonusLottoNumber = new LottoNumber(7);
        Winning winning = new Winning(lotto, bonusLottoNumber);
        RankResult rankResult = new RankResult(lottos, winning);
        assertThat(rankResult).isNotNull();
    }
}

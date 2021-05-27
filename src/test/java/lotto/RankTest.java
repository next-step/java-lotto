package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.entity.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("일치하는 숫자에 등수를 확인한다.")
    public void 등수_확인() {
        Result result = new Result(new Lotto(new Number(1), new Number(2), new Number(3)
                , new Number(4), new Number(5), new Number(6)));

        LottoList lottoList = new LottoList(
                new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)) // 1등
                , new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7)) // 2등
                , new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(8), new Number(7)) // 3등
                , new Lotto(new Number(1), new Number(2), new Number(3), new Number(9), new Number(8), new Number(7)) // 4등
        );

        result.confirm(lottoList, new LottoPrice("1000"));
        Rank rank = result.rank();

        assertThat(rank.first()).isEqualTo(1);
        assertThat(rank.second()).isEqualTo(1);
        assertThat(rank.third()).isEqualTo(1);
        assertThat(rank.fourth()).isEqualTo(1);
    }
}

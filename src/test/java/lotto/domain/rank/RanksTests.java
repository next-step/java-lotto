package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RanksTests {
    @DisplayName("Rank 리스트를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Rank> rankList = Arrays.asList(FIRST, FIRST);
        assertThat(Ranks.create(rankList)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 한다.")
    @Test
    void sideEffectTest() {
        List<Rank> rankList = new ArrayList<>();
        rankList.add(FIRST);
        Ranks ranks = Ranks.create(rankList);
        assertThat(ranks.size()).isEqualTo(1);

        rankList.add(FIRST);
        assertThat(ranks.size()).isEqualTo(1);
    }

    @DisplayName("당첨금액의 합계를 구할 수 있어야 한다.")
    @Test
    void calculateTotalPrize() {
        List<Rank> rankList = Arrays.asList(FIRST, SECOND);
        Ranks ranks = Ranks.create(rankList);
        assertThat(ranks.calculateTotalPrize()).isEqualTo(FIRST.getPrice() + SECOND.getPrice());
    }
}

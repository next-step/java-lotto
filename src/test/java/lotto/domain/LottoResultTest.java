package lotto.domain;

import lotto.utils.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("LottoResult 생성자 테스트")
    void constructor() {
        assertThat(new LottoResult())
                .isEqualTo(new LottoResult());
    }

    @Test
    void test입니다(){
        Map<Rank, Integer> ranks = new EnumMap<Rank, Integer>(Rank.class);
        Rank[] ranks1 = Rank.values();
        Arrays.stream(Rank.values())
                .forEach(rank -> {
                    ranks.getOrDefault(rank, rank.getCountOfMatch());
                });

        System.out.println();
    }
}

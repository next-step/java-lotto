package lotto.service;

import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundServiceTest {
    @Test
    void testBuy(){
        RoundService roundService = new RoundService();
        Set<Pick> myPicks = new HashSet<>();
        myPicks.add(new Pick(PickType.AUTO, Arrays.asList(3,5,6,7,8,9)));
        Round round = roundService.buy(myPicks);

        assertThat(round).isNotNull();
        assertThat(round.getMyPicks()).containsAll(myPicks);
    }
}

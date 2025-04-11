package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    public void setUp() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> list = new ArrayList<>();
        list.add(lotto);
        lottos = new Lottos(list);
    }

    @Test
    public void correctPlacementCountsTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);

        int[] placementCounts = lottos.placementCounts(winningLotto);
        int[] expectedPlacementCounts = {0, 0, 0, 0, 0, 0, 1};

        for (int i = 0; i < placementCounts.length; i++) {
            assertThat(placementCounts[i]).isEqualTo(expectedPlacementCounts[i]);
        }
    }
}

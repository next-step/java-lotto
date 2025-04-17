package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    public void setUp() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 8, 9);
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2 = new Lotto(number2);
        Lotto lotto3 = new Lotto(numbers3);
        List<Lotto> list = new ArrayList<>();
        list.add(lotto);
        list.add(lotto2);
        list.add(lotto3);
        lottos = new Lottos(list);
    }

    @Test
    @DisplayName("로또 당첨 번호과 일치하는 번호 개수 확인")
    public void correctPlacementCountsTest() {
        //Given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        //When
        Map<Integer, Integer> placementCounts = lottos.placementCounts(winningLotto);
        //Then
        assertThat(placementCounts).containsEntry(6, 2)
                .containsEntry(4,1);
    }
}

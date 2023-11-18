package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoGenerationTest {

    @Test
    @DisplayName("수동로또와 자동로또를 생성하여 리턴한다")
    void 로또생성_확인() {
        int count = 10;
        NumberGeneration numberGeneration = new RandomNumberGeneration();
        List<List<Integer>> manualNumbers = new ArrayList<>();
        manualNumbers.add( new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        manualNumbers.add( new ArrayList<>(Arrays.asList(7,8,9,10,11,12)));
        manualNumbers.add( new ArrayList<>(Arrays.asList(13,14,15,16,17,19)));

        LottoGeneration lottoGeneration = new LottoGeneration(manualNumbers,numberGeneration, count);
        assertThat(lottoGeneration.find().size()).isEqualTo(count);

    }
}

package lotto;

import lotto.utile.CollectionsNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionsNumberTest {
    @Test
    @DisplayName("배열 섞기 테스트")
    void shuffleNumberTest() {
        int[] number = {1,2,3,4,5,6};
        number = CollectionsNumber.shuffleNumber(number);
        Assertions.assertThat(number).contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("배열 정렬 테스트")
    void sortArrayNumberTest() {
        int[] number = {4,3,2,5,1,6};
        CollectionsNumber.sortArrayNumber(number);
        Assertions.assertThat(number).containsExactly(1,2,3,4,5,6);
    }
}

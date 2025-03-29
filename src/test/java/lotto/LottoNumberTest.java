package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {
    @Test
    @DisplayName("셔플된 번호 리스트의 크기는 45개이다.")
    void testShuffledNumbersSize() {
        List<Integer> shuffledNumbers = LottoNumber.getInstance().getShuffledNumbers();
        assertEquals(45, shuffledNumbers.size(), "셔플된 번호 리스트는 45개의 숫자를 포함해야 합니다.");
    }

    @Test
    @DisplayName("셔플된 번호의 범위는 1부터 45까지이다.")
    void testShuffledNumbersRange() {
        List<Integer> shuffledNumbers = LottoNumber.getInstance().getShuffledNumbers();
        assertTrue(shuffledNumbers.stream().allMatch(num -> num >= 1 && num <= 45));
    }
}

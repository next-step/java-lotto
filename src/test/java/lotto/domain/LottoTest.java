package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("null 값 전달 시 NullPointerException 발생 확인")
    public void testNullNumbers() {
        List<Integer> numbers = null;
        assertThrows(NullPointerException.class, () -> new Lotto(numbers));
    }

    @Test
    @DisplayName("번호 개수가 6개가 아닐 때 IllegalArgumentException 발생 확인")
    public void testInvalidSize() {
        // 5개의 번호를 전달하여 테스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    @DisplayName("중복된 번호가 있을 때 IllegalArgumentException 발생 확인")
    public void testDuplicateNumbers() {
        // 중복된 번호 5가 포함됨
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    @DisplayName("범위를 벗어난 번호가 있을 때 IllegalArgumentException 발생 확인")
    public void testOutOfRangeNumbers() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    @DisplayName("올바른 번호 목록 전달 시 예외가 발생하지 않는지 확인")
    public void testValidNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(numbers));
    }
}

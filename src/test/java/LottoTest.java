import Lotto.domain.Lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    void testGenerateLottoNumbers() {
        int[] lottoNumbers = Lotto.generateLottoNumbers();

        // 1. 숫자 6개가 생성되는지 확인
        assertEquals(6, lottoNumbers.length);

        // 2. 모든 숫자가 1~45 사이인지 확인
        for (int number : lottoNumbers) {
            assertTrue(number >= 1 && number <= 45, "Number out of range: " + number);
        }

        // 3. 숫자가 중복되지 않는지 확인
        long uniqueCount = Arrays.stream(lottoNumbers).distinct().count();
        assertEquals(6, uniqueCount, "Duplicate numbers found in: " + Arrays.toString(lottoNumbers));

        // 4. 숫자가 오름차순으로 정렬되어 있는지 확인
        int[] sortedNumbers = Arrays.copyOf(lottoNumbers, lottoNumbers.length);
        Arrays.sort(sortedNumbers);
        assertArrayEquals(sortedNumbers, lottoNumbers, "Numbers are not sorted");
    }

    @Test
    void testGenerateLottos() {
        int purchasedQty = 5;
        List<Lotto> lottos = Lotto.generateLottos(purchasedQty);

        // 1. 요청한 개수만큼 로또가 생성되었는지 확인
        assertEquals(purchasedQty, lottos.size());

        // 2. 각 로또가 유효한 숫자 범위를 가지는지 확인
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();

            // 로또 번호가 6개인지 확인
            assertEquals(6, lottoNumbers.size(), "Lotto size mismatch: " + lottoNumbers);

            // 각 번호가 1~45 사이인지 확인
            for (int number : lottoNumbers) {
                assertTrue(number >= 1 && number <= 45, "Number out of range: " + number);
            }

            // 번호가 중복되지 않는지 확인
            long uniqueCount = lottoNumbers.stream().distinct().count();
            assertEquals(6, uniqueCount, "Duplicate numbers found in: " + lottoNumbers);

            // 번호가 오름차순으로 정렬되어 있는지 확인
            List<Integer> sortedNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
            assertEquals(sortedNumbers, lottoNumbers, "Numbers are not sorted: " + lottoNumbers);
        }
    }

    @Test
    void testToString() {
        Lotto lotto = new Lotto();
        String lottoString = lotto.toString();

        // toString()이 숫자 6개를 포함하는지 확인
        assertTrue(lottoString.matches("\\[\\d+(, \\d+)*\\]"), "toString() format invalid: " + lottoString);

        // 번호가 6개인지 확인
        String[] numbers = lottoString.replaceAll("[\\[\\]]", "").split(", ");
        assertEquals(6, numbers.length, "toString() does not contain 6 numbers");
    }
}

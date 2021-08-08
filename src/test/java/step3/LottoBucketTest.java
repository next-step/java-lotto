package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBucketTest {
    @Test
    @DisplayName("LottoNumbers 추가 테스트")
    void addNewLottoNumbersTest() {
        LottoBucket lottoBucket = new LottoBucket();

        int before = lottoBucket.size();

        lottoBucket.add(new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int after = lottoBucket.size();

        assertThat(after).isEqualTo(before + 1);
    }
}

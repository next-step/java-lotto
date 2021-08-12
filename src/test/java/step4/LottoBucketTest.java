package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBucketTest {
    @Test
    @DisplayName("LottoNumbers 추가 테스트")
    void addTest() {
        LottoBucket lottoBucket = new LottoBucket();

        int before = lottoBucket.size();

        lottoBucket.add(new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int after = lottoBucket.size();

        assertThat(after).isEqualTo(before + 1);
    }

    @Test
    @DisplayName("LottoBucket간 합치는 테스트")
    void mergeTest() {
        LottoBucket lottoBucket1 = new LottoBucket();
        lottoBucket1.add(new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoBucket lottoBucket2 = new LottoBucket();
        lottoBucket2.add(new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 6)));

        lottoBucket1.merge(lottoBucket2);

        assertThat(lottoBucket1.size()).isEqualTo(2);
    }
}

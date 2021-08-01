package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBucketTest {
    @Test
    @DisplayName("LottoNumbers 추가 테스트")
    void addNewLottoNumbersTest() {
        LottoBucket lottoBucket = new LottoBucket();

        int before = lottoBucket.size();

        lottoBucket.addRandomLotto(new LottoRandomNumberGenerator());

        int after = lottoBucket.size();

        assertThat(after).isEqualTo(before + 1);
    }
}

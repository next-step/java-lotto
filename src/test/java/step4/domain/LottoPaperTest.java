package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoPaperTest {

    @DisplayName("생성")
    @Test
    void createTest() {
        LottoPaper lottoPaper = LottoPaper.of(1, Collections.EMPTY_LIST);

        assertThat(lottoPaper).isEqualTo(LottoPaper.of(1, Collections.EMPTY_LIST));
    }

    @DisplayName("살 수 있는 금액보다 manual 로또의 갯수가 많으면 익셉션")
    @Test
    void lessThanManualTest() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPaper.of(Money.of(1000), Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6")));
    }
}

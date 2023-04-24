package lotto.domain.rating;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningRatingTypeTest {
    @Test
    @DisplayName("객체 find 테스트")
    void findBy() {
        assertAll(
                () -> assertThat(WinningRatingType.findBy(5, true))
                        .isEqualTo(WinningRatingType.SECOND),
                () -> assertThat(WinningRatingType.findBy(5, false))
                        .isEqualTo(WinningRatingType.THIRD),
                () -> assertThat(WinningRatingType.findBy(3, true))
                        .isEqualTo(WinningRatingType.FIFTH),
                () -> assertThat(WinningRatingType.findBy(3, false))
                        .isEqualTo(WinningRatingType.FIFTH)
        );
    }
}

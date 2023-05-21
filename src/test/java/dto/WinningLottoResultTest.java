package dto;

import domain.LottoResult;
import domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import util.LottoTestHelper;

import java.util.List;

class WinningLottoResultTest {

    @ParameterizedTest
    @EnumSource(value = LottoResult.class, names = {"FIRST", "SECOND", "THIRD", "FORTH", "FIFTH"})
    @DisplayName("당첨된 로또로만 생성할 수 있다")
    void create(LottoResult result) {
        new WinningLottoResult(List.of(result));
    }

    @Test
    @DisplayName("당첨되지 않은 로또가 포함되면 예외가 발생한다")
    void create2() {
        Assertions.assertThatThrownBy(() -> new WinningLottoResult(List.of(LottoResult.FIRST, LottoResult.NONE)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

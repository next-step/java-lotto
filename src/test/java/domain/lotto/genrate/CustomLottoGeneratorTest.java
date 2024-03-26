package domain.lotto.genrate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomLottoGeneratorTest {


    @DisplayName("수동으로 로또 번호를 추출할 수 있다.")
    @Test
    void create() {
        CustomLottoGenerator customLottoGenerator = CustomLottoGenerator.from(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 10)));
        assertThat(customLottoGenerator.create()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(customLottoGenerator.create()).isEqualTo(List.of(1, 2, 3, 4, 5, 10));
    }

    @DisplayName(" 로또 사이즈가 안 맞을 경우 예외를 던진다. 선택할 수 없다.")
    @Test
    void createWithError() {
        assertThatThrownBy(() -> CustomLottoGenerator.from(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동로또 개수보다 많이 생성 요청을 할 경우, 예외를 던진다.")
    @Test
    void createWithOverRequest() {
        CustomLottoGenerator from = CustomLottoGenerator.from(List.of());
        assertThatThrownBy(() -> {
            from.create();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}

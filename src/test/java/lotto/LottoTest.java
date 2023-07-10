package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @Test
    @DisplayName("정상 입력시 로또 객체 정상 생성")
    void create() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }
}

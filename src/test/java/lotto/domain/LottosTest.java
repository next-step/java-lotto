package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("null 또는 size 가 0 일 때, 로또리스트 생성 에러")
    @Test
    void createError(){
        assertThatThrownBy(() -> new Lottos(null))
                .isInstanceOf(InputError.class);
        assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(InputError.class);
    }
}
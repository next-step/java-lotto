package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 정상적인_로또번호_생성_Test(){
        assertThat(LottoNumber.create(5)).isEqualTo(LottoNumber.create(5));
    }

    @Test
    void 정상적인_로또번호_생성_문자열_Test(){
        assertThat(LottoNumber.createByString("5")).isEqualTo(LottoNumber.create(5));
    }

    @Test
    void 비정상적인_로또번호_생성_Test(){
        assertThatThrownBy(() -> {
            LottoNumber.create(50);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 비정상적인_로또번호_생성_문자열_Test(){
        assertThatThrownBy(() -> {
            LottoNumber.createByString("one");
        }).isInstanceOf(RuntimeException.class);
    }
}
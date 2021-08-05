package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @Test
    void 로또_당첨번호_에러_메세지_확인() {
        assertThatThrownBy(()-> new LottoMachine("1,2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new LottoMachine("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
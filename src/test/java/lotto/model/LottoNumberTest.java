package lotto.model;

import domain.Digit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 로또의범위를_벗어난_숫자생성시도_에외처리(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            new LottoNumber(46);
        });
    }}
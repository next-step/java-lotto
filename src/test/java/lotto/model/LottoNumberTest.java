package lotto.model;

import domain.Digit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 로또의범위를_벗어난_숫자생성시도_에외처리(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            LottoNumber.of(46);
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            LottoNumber.of(0);
        });
    }

    @Test
    void 객체생성_일치기준_테스트(){
        LottoNumber expected = LottoNumber.of(2);
        LottoNumber actual = LottoNumber.of(2);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 정렬_테스트(){
        List<LottoNumber> actual = new ArrayList<>(Arrays.asList(LottoNumber.of(3), LottoNumber.of(2), LottoNumber.of(1)));
        Collections.sort(actual);
        assertThat(actual).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3));
    }

    @Test
    void 인스턴스_재사용_테스트(){
        LottoNumber lotto1 = LottoNumber.of(1);
        LottoNumber lotto2 = LottoNumber.of(1);
        assertThat(lotto1 == lotto2).isTrue();
    }
}
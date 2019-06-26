package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber();
    }

    @Test
    void 로또번호6개생성() {
        List<Integer> numbers = lottoNumber.getNumbers();
        Set<Integer> eachOtherNumbers = new HashSet<>();
        for (Integer number : numbers) {
            eachOtherNumbers.add(number);
        }
        assertThat(eachOtherNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또전체번호생성확인() {
        List<Integer> numbers = lottoNumber.createLottoAllNumbers();
        Set<Integer> eachOtherNumbers = new HashSet<>();
        for (Integer number : numbers) {
            eachOtherNumbers.add(number);
        }
        assertThat(eachOtherNumbers.size()).isEqualTo(45);
    }

}

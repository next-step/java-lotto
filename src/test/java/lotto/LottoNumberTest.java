package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber();
    }

    @Test
    void defaultLottoNumberWithCollectionShuffleTest() {
        assertThat(lottoNumber.getLottoNumbers()).hasSize(6);
    }

    @Test
    void customLottoNumberTest() {
        List<Integer> testLottoNumber = new ArrayList<>();
        testLottoNumber.add(1);
        testLottoNumber.add(2);
        testLottoNumber.add(3);
        testLottoNumber.add(4);
        testLottoNumber.add(5);
        testLottoNumber.add(6);
        lottoNumber = new LottoNumber(testLottoNumber);
        assertThat(lottoNumber.getLottoNumbers()).hasSize(6);
        assertThat(lottoNumber.getLottoNumbers()).contains(1,2,3,4,5,6);
    }
}

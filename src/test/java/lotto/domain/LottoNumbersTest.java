package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {

    private LottoNumbers answerLottoNumber;

    @BeforeEach
    void setUp() {
        answerLottoNumber = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("6개의 로또번호가 같으면 동등한 객체다.")
    void comparePickedLottoTest() {
        LottoNumbers selectLotto = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));

        assertThat(answerLottoNumber).isEqualTo(selectLotto);
    }

    @Test
    @DisplayName("로또 번호 간 비교해서 전부 맞는지 반환된다.")
    void compareTest_allMatched() {
        LottoNumbers secondLotto = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));

        assertThat(answerLottoNumber.compare(secondLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 간 비교해서 전부 틀린지 반환된다.")
    void compareTest_notMatched() {
        LottoNumbers secondLotto = new LottoNumbers(Arrays.asList(7,8,9,10,11,12));

        assertThat(answerLottoNumber.compare(secondLotto)).isEqualTo(0);
    }
}

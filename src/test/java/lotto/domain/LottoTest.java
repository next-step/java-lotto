package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    Lotto lotto;
    List<LottoNumber> lottoList;

    @BeforeEach
    void setUp() {
//        lotto = new Lotto();
//        lottoList = lotto.getLottoList();
    }

    @DisplayName(value = "로또가 생성될 때, 로또 하나에는 6개의 숫자가 들어간다.")
    @Test
    void checkValidSize() {
        assertThat(lottoList.size()).isEqualTo(6);
    }

//    @DisplayName(value = "로또의 범위는 1~45까지이다.")
//    @Test
//    void checkValidRange() {
//       boolean isInRange = lottoList.stream().allMatch(LottoTest::isInRange);
//       assertThat(isInRange).isTrue();
//    }

    static boolean isInRange(final int number) {
        return (number >= 1 && number <= 45);
    }
}

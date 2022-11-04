package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    List<LottoNumber> lottoNumberTest;
    List<LottoNumbers> purchasedLottoNumbers;

    LottoNumber one = new LottoNumber(1);
    LottoNumber three = new LottoNumber(3);
    LottoNumber five = new LottoNumber(5);
    LottoNumber seven = new LottoNumber(7);
    LottoNumber nine = new LottoNumber(9);
    LottoNumber twentyOne = new LottoNumber(21);
    LottoNumber twentyTwo = new LottoNumber(22);
    LottoNumber thirtyTwo = new LottoNumber(32);
    LottoNumber fortyFive = new LottoNumber(45);

    @BeforeEach
    void setUp() {
        lottoNumberTest = Lists.newArrayList(one, three, five, seven, nine, twentyTwo);

        purchasedLottoNumbers = List.of(
                new LottoNumbers(List.of(one, three, five, seven, nine, fortyFive)),
                new LottoNumbers(List.of(one, three, five, seven, nine, twentyOne))
        );

    }

    @Test
    @DisplayName("로또 번호가 6자리가 아닌 경우 예외 발생")
    void 로또_5자리_확인() {
        lottoNumberTest.remove(1);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(
                lottoNumberTest));
    }

    @Test
    @DisplayName("로또 번호가 6자리가 아닌 경우 예외 발생")
    void 로또_7자리_확인() {
        lottoNumberTest.add(thirtyTwo);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(
                lottoNumberTest));
    }
}
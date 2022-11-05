package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumbersTest {
    List<LottoNumber> lottoNumberTest;
    List<LottoNumbers> purchasedLottoNumbers;

    LottoNumber one = new LottoNumber(1);
    LottoNumber three = new LottoNumber(3);
    LottoNumber five = new LottoNumber(5);
    LottoNumber seven = new LottoNumber(7);
    LottoNumber eight = new LottoNumber(8);
    LottoNumber nine = new LottoNumber(9);
    LottoNumber twelve = new LottoNumber(12);
    LottoNumber twentyOne = new LottoNumber(21);
    LottoNumber twentyTwo = new LottoNumber(22);
    LottoNumber thirtyTwo = new LottoNumber(32);

    @BeforeEach
    void setUp() {
        lottoNumberTest = Lists.newArrayList(one, three, five, seven, nine, twentyTwo);
        purchasedLottoNumbers = List.of(
                new LottoNumbers(List.of(one, three, five, seven, nine, twentyTwo)),
                new LottoNumbers(List.of(one, three, eight, twentyTwo, twentyOne, thirtyTwo)),
                new LottoNumbers(List.of(one, three, five, twelve, nine, twentyOne)),
                new LottoNumbers(List.of(one, three, five, nine, thirtyTwo, twentyOne))
        );

    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨된 번호인 경우 에러 발생")
    void 로또_보너스_확인_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLottoNumbers(
                new LottoNumbers(lottoNumberTest), three));
    }

}
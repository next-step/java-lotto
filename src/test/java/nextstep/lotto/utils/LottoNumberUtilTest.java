package nextstep.lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumberUtilTest {

    @Test
    @DisplayName("로또번호가 6개 생성되는지 확인")
    void generateLottoNumberTest() {
        assertThat(LottoNumberUtil.generator()).hasSize(6);
    }

    @Test
    @DisplayName("문자로된 로또번호가 LottoNumber 객체의 리스트로 제대로 변환되는지 확인 확인")
    void transLottoNumberTest() {
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("1");
        stringNumbers.add("2");
        stringNumbers.add("3");
        stringNumbers.add("4");
        stringNumbers.add("5");
        stringNumbers.add("6");
        assertThat(LottoNumberUtil.transStringNumberToLottoNumber(stringNumbers)).hasSize(6);
    }
}
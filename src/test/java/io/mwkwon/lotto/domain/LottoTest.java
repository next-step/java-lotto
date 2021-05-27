package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또_생성_static_method_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto lotto = Lotto.create(lottoNumbers);
        assertThat(lotto).isEqualTo(Lotto.create(lottoNumbers));
    }

    @Test
    void 중복된_로또_번호가_포함된_경우_에러_정상_발생_여부_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(5));

        assertThatThrownBy(() -> Lotto.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 로또번호 6개가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true", "7:false"}, delimiter = ':')
    void 생성된_로또_번호와_동일한_로또_번호가_존재하지는_체크_정상_동작_테스트(int number, boolean expected) {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto lotto = Lotto.create(lottoNumbers);
        assertThat(lotto.isContains(LottoNumber.create(number))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,7:5",
            "1,2,3,4,7,8:4",
            "1,2,3,7,8,9:3",
            "1,2,7,8,9,10:2",
            "1,7,8,9,10,11:1",
            "7,8,9,10,11,12:0"
    }, delimiter = ':')
    void 당첨_로또와_일치하는_로또_번호_갯수_반환_동작_테스트(String winningLottoNumbers, int excepted) {
        List<LottoNumber> winningLotto = Stream.of(winningLottoNumbers.split(","))
                .map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber)))
                .collect(Collectors.toList());
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto buyLotto = Lotto.create(lottoNumbers);
        long matchCount = buyLotto.calcMatchLottoNumberCount(Lotto.create(winningLotto));
        assertThat(matchCount).isEqualTo(excepted);
    }
}

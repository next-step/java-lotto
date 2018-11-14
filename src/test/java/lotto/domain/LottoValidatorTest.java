package lotto.domain;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_45_이상() throws Exception {
        List<LottoNo> lottoNos = Arrays.asList(46, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        LottoValidator.validate(lottoNos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_갯수가_6개가_넘는_경우() throws Exception {
        List<LottoNo> lottoNos = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        LottoValidator.validate(lottoNos);
    }

}
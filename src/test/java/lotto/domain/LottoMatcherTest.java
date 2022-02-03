package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {
    
    @Test
    public void 사용자가_입력한_저번주당첨금액과_비교_6개_모두_일치() {
        //given
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        
        //when
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(6);
    }
}
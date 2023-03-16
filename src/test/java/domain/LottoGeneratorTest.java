package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LottoGeneratorTest {
    @Test
    void generateLottoNumbersTDD() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(LottoNumber.valueOf(i));
        }

        System.out.println(lottoNumbers);
        Collections.shuffle(lottoNumbers);

        System.out.println(lottoNumbers);
        System.out.println(lottoNumbers.subList(0, 6));

        assertThat(lottoNumbers.size(), is(45));
    }

    @Test
    void generateLottoNumbersTest() {
        List<LottoNumber> lottoNumberList = LottoNumberGenerator.generateLottoNumbers();
        System.out.println(lottoNumberList);
        assertThat(lottoNumberList.size(), is(6));

    }

}

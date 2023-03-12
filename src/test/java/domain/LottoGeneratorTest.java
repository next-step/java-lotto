package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void generateLottoNumbersTDD() {
        LottoNumberGenerator lottoGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        System.out.println(lottoNumbers);
        Collections.shuffle(lottoNumbers);

        System.out.println(lottoNumbers);
        System.out.println(lottoNumbers.subList(0, 6));

    }

    @Test
    void generateLottoNumbersTest() {
        List<LottoNumber> lottoNumberList = LottoNumberGenerator.generateLottoNumbers();
        System.out.println(lottoNumberList);

        lottoNumberList = LottoNumberGenerator.generateLottoNumbers();
        System.out.println(lottoNumberList);

        lottoNumberList = LottoNumberGenerator.generateLottoNumbers();
        System.out.println(lottoNumberList);

        lottoNumberList = LottoNumberGenerator.generateLottoNumbers();
        System.out.println(lottoNumberList);
    }

}

package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @Test
    void collectionShuffleTest() {
        List<Integer> number = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(45);
            number.add(num);
        }
        Collections.shuffle(number);
        System.out.println("number = " + number);
    }

    @Test
    @DisplayName("로또 번호는 6개 숫자로 생성된다.")
    void generateNumberShuffleTest() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumber();
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 생성은 Collections.shuffle() 메소드를 활용한다.")
    void generateNumberShuffleTest2() {
        for (int i = 0; i < 2; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumber();
            System.out.println("lottoNumbers = " + lottoNumbers);
        }
    }

    @Test
    @DisplayName("로또 번호 출력은 Collections.sort()를 활용한다.")
    void usingSortTest() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumber();
        Collections.sort(lottoNumbers);

        System.out.println("lottoNumbers = " + lottoNumbers);
    }


    @Test
    @DisplayName("로또 번호가 45를 초과하는 경우 exception throw")
    void overRangeTest() {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.valueOf(55));
    }

    @Test
    @DisplayName("로또 번호 캐싱 테스트")
    void cachingNumberTest() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(3);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(3);

        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }
}

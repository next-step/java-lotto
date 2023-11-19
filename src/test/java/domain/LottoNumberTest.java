package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoRandomNumberGenerator;

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
    @DisplayName("로또 생성은 Collections.shuffle() 메소드를 활용한다.")
    void generateNumberShuffleTest() {
        List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();

        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
    }
    @Test
    @DisplayName("로또 생성은 Collections.shuffle() 메소드를 활용한다.")
    void generateNumberShuffleTest2() {
        for (int i = 0; i < 2; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();
            System.out.println("lottoNumbers = " + lottoNumbers);
        }
    }

    @Test
    @DisplayName("로또 번호 출력은 Collections.sort()를 활용한다.")
    void usingSortTest() {
        List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();
        Collections.sort(lottoNumbers);

        System.out.println("lottoNumbers = " + lottoNumbers);
    }

    @Test
    @DisplayName("당첨 번호를 6개 미만으로 입력하는 경우 Exception이 발생한다.")
    void invalidInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(1, 2, 3, 4, 5));
    }

}

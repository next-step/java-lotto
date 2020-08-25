package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class generateLottoTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("번호 생성 테스트")
    @Test
    void generateLottoTest() {
        List<Integer> numList = numberGenerator.generate();

        assertThat(numList.size()).isEqualTo(6);
    }

    @DisplayName("번호 중복 여부 테스트")
    @Test
    void generateTest() {
        Set<Integer> set = new HashSet<>();

        List<Integer> numList = numberGenerator.generate();
        for (int i = 0; i < 6; i++) {
            set.add(numList.get(i));
        }
        assertThat(set.size()).isEqualTo(6);
    }

    @DisplayName("정렬 테스트")
    @Test
    void arrangeNumber() {
        List<Integer> numList = numberGenerator.generate();
        Collections.sort(numList);

        for (int i = 0; i < 6; i++) {
            System.out.println(numList.get(i));
        }
    }

    @DisplayName("몇개나 일치하나 테스트")
    @Test
    void checkCorrected() {
        List<Integer> numList = numberGenerator.generate();
        Collections.sort(numList);

        String lastWinnerNumber = "1,2,3,4,5,6";
        String[] input = lastWinnerNumber.split(",");

        int count = 0;
        for (int i = 0; i < 6; i++) {
            System.out.println(numList.get(i));
            if (numList.contains(Integer.parseInt(input[i]))) {
                count++;
            }
        }
        System.out.println("cnt = " + count);
    }

    @Test
    void setLotto() {
        List<Integer> numList = numberGenerator.generate();
        Lotto numbers = new Lotto(numList);

        assertThat(numbers.lottoNumber.size()).isEqualTo(6);
    }
}

package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumbergeneratorTest {
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


    @Test
    void setLotto() {
        List<Integer> numList = numberGenerator.generate();
        Lotto numbers = new Lotto(numList);

        assertThat(numbers.getLottoNumber().size()).isEqualTo(6);
    }
}

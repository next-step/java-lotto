package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectionStudyTest {

    @DisplayName("IntStream range로 숫자열 생성 해보기")
    @Test
    public void intStreamRangeTest() {
        IntStream intStream = IntStream.range(1, 45);
        IntStream intStreamClosed = IntStream.rangeClosed(1, 45);

        assertThat(intStream.count()).isEqualTo(44);
        assertThat(intStreamClosed.count()).isEqualTo(45);
    }

    @DisplayName("Collections shuffle 학습하기")
    @Test
    public void shuffleTest() {
        List<Integer> lottoNumber1 = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> lottoNumber2 = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumber1);
        Collections.shuffle(lottoNumber2);

        assertThat(lottoNumber1).containsExactlyInAnyOrderElementsOf(lottoNumber2);
    }

    @DisplayName("subList 사용해 리스트중 6개만 가져오기")
    @Test
    public void getWinningNumberTest() {
        List<Integer> lottoNumber = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumber);

        List<Integer> winningNumber = lottoNumber.subList(0, 6);
        winningNumber.sort(comparingInt(Integer::intValue));

        assertThat(winningNumber).hasSize(6);
    }

    @DisplayName("containsAll 사용해 일치여부 확인하기")
    @Test
    public void containsAllTrueTest() {
        List<Integer> winningNumber = Arrays.asList(11, 13, 17, 19, 23, 29);
        List<Integer> myNumber = Arrays.asList(11, 13, 17, 19, 23, 29);

        boolean contains = winningNumber.containsAll(myNumber);

        assertThat(contains).isTrue();
    }

    @DisplayName("containsAll 사용해 일치여부 확인하기")
    @Test
    public void containsAllFalseTest() {
        List<Integer> winningNumber = Arrays.asList(11, 13, 17, 19, 23, 29);
        List<Integer> myNumber = Arrays.asList(11, 13, 17, 19, 23, 30);

        boolean containsAll = winningNumber.containsAll(myNumber);
        assertThat(containsAll).isFalse();
    }

    @DisplayName("contains 사용해 일치 개수 확인하기")
    @Test
    public void containsTrueTest() {
        List<Integer> winningNumber = Arrays.asList(11, 13, 17, 19, 23, 29);
        List<Integer> myNumber = Arrays.asList(11, 13, 17, 20, 30, 40);

        long count = myNumber.stream()
                .filter(winningNumber::contains)
                .count();

        assertThat(count).isEqualTo(3);
    }

}

package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    private static final int LOTTO_AMOUNT = 1000;

    @DisplayName(value = "구매금액에 해당하는 로또 발급")
    @ParameterizedTest
    @ValueSource(ints = {14000})
    void lottoIssuance(final int purchaseAmount) {
        assertThat(purchaseAmount / LOTTO_AMOUNT).isSameAs(14);
    }

    @DisplayName(value = "로또 번호 생성")
    @Test
    void createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45)
                .forEach(numbers::add);

        assertThat(numbers.size()).isSameAs(45);
        assertThat(numbers.get(6)).isSameAs(7);

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        assertThat(lottoNumbers.size()).isSameAs(6);
    }

    @DisplayName(value = "당첨번호 확인")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void confirmWinningNumber(final int number) {
        List<Integer> winningNumbers = Arrays.asList(3, 7, 9, 11, 13, 15);
        List<Integer> purchaseNumbers = Arrays.asList(3, 7, 8, 13, 23, 45);

        long count1 = winningNumbers.stream()
                .filter(it -> it == number)
                .count();
        assertThat(count1).isSameAs(1L);

        long count2 = purchaseNumbers.stream()
                .filter(it -> winningNumbers.contains(it))
                .count();
        assertThat(count2).isSameAs(3L);
    }

    @Test
    void temp() {
        String input = "1, 2, 3, 4, 5, 6";
        int[] values = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> results = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

//        List<Integer> results = Arrays.stream(values).boxed()
//                .collect(Collectors.toList());

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}

package camp.nextstep.edu.rebellion.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final int LOTTERY_PRICE = 1000;

    // private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = Arrays.asList(1,2,3,4,5,6,7,8,)
    public static void main(String[] args) {
        int purchaseAmount = 10000;
        int lottoCounts = purchaseAmount / LOTTERY_PRICE;

        List<Integer> lottoCandidateNumbers =
                IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                        .boxed()
                        .collect(Collectors.toList());

        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            Collections.shuffle(lottoCandidateNumbers);
            lottoNumbers =  lottoCandidateNumbers
                    .stream()
                    .limit(LOTTO_NUMBERS)
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(lottoNumbers);
        }

        List<Integer> winnerNumbers = Arrays.stream("1,2,3,4,5,6".split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(winnerNumbers);

        int count = lottoNumbers.stream().mapToInt(number -> {
            if(winnerNumbers.stream().anyMatch(wn -> wn == number)) {
                return 1;
            }
            return 0;
        }).sum();

        System.out.println(count);
    }
}

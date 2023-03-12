package lottery;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private static final int LOTTO_LIMIT = 45;
    private static final int LOTTO_TICKET_LENGTH = 6;
    private final int[] lottoNumbers;
    public Lottery() {
        lottoNumbers =
                IntStream.rangeClosed(1, LOTTO_LIMIT)
                        .toArray();
    }

    public int[] getLottoNumber() {
        return lottoNumbers;
    }

    public List<Integer> publishLottery() {
        List<Integer> shuffleNumber =
                Arrays.stream(lottoNumbers)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.shuffle(Arrays.asList(shuffleNumber));
        return shuffleNumber.subList(0, LOTTO_TICKET_LENGTH);
    }
}



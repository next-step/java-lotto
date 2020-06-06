package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class Lotto {

    private static final int LOTTO_MAX_LIMIT = 45;
    private static final int LOTTO_DRAW_LIMIT = 6;
    private static final int LOTTO_DRAW_BASE_NUMBER = 0;

    // each Lotto numbers.
    private List<Integer> lottoNumbers;

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList());


    public Lotto(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Integer::compareTo);
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto auto() {

        Collections.shuffle(new ArrayList<>(drawLottoNumbers()));

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new ArrayList<>(drawLottoNumbers()));

    }

    public static Lotto from(List<Integer> winningNumberList) {

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new ArrayList<>(winningNumberList));

    }


    public static List<Integer> drawLottoNumbers() {
        return lottoGameNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    // issue
    public static LottoTickets issueLotto(int gameCount) {

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(Lotto.auto());
        }
        return new LottoTickets(lottoList);

    }

    public static Lotto checkWiningNumber(String[] winningNumberArray) {

        if (winningNumberArray.length != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        return Lotto.from(Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

}

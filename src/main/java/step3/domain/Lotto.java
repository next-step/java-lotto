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

    private int bonusNumber;

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList());


    public Lotto(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Integer::compareTo);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = 0;

    }

    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        lottoNumbers.sort(Integer::compareTo);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;

    }


    public static Lotto auto() {

        // default 1 to LOTTO_MAX_LIMIT (45)
        List<Integer> lottoGameNumbersInner = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
                .boxed()
                .collect(Collectors.toList());

         Collections.shuffle(lottoGameNumbersInner);

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(drawLottoNumbers(lottoGameNumbersInner));

    }

    public static Lotto from(List<Integer> winningNumberList, int bonusBall) {

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new ArrayList<>(winningNumberList), bonusBall);

    }


    public static List<Integer> drawLottoNumbers(List<Integer> lottoGameNumbersInner) {
        return lottoGameNumbersInner.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
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

    public static Lotto checkWiningNumber(String[] winningNumberArray, String bonusNumber) {

        if (winningNumberArray.length != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        Number.checkNotNumber(bonusNumber);
        Number.checkNumber(bonusNumber);

        int bonusNumberInt = Integer.valueOf(bonusNumber);

        if ( bonusNumberInt > LOTTO_DRAW_BASE_NUMBER &&  bonusNumberInt > LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }

        return Lotto.from(Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList()), bonusNumberInt);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}

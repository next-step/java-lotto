package step2.domain;

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

    // each Lotto numbers.
    private List<Integer> lottoNumbers = new ArrayList<>();

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT).boxed().collect(Collectors.toList());


    public static Lotto getInstance() {

        Lotto lotto = new Lotto();

        // shuffle
        List<Integer> shuffleTemp = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT).boxed().collect(Collectors.toList());

        Collections.shuffle(shuffleTemp);

        // static 으로 field 에 있는 값을 shuffle 을 할 경우, 계속 같은 값으로만 출력이 되는데 이유가 뭘까요... ;;;;;
        // 인스턴스 생성 때마다 45자리 수 생성을 일단 해서 shuffle 이 되게 하긴 했는데, 궁금하네요.
        // Collections.shuffle(lottoGameNumbers);

        // pick LOTTO_DRAW_LIMIT
        lotto.lottoNumbers = drawLottoNumbers(shuffleTemp);
        //lotto.lottoNumbers = drawLottoNumbers(lottoGameNumbers);

        lotto.lottoNumbers.sort(Integer::compareTo);

        return lotto;

    }

    public static Lotto from(List<Integer> winningNumberList) {

        Lotto lotto = new Lotto();

        // pick LOTTO_DRAW_LIMIT
        lotto.lottoNumbers = drawLottoNumbers(winningNumberList);
        lotto.lottoNumbers.sort(Integer::compareTo);

        return lotto;

    }


    public static List<Integer> drawLottoNumbers(List<Integer> winningNumberList) {
        return winningNumberList.subList(0, LOTTO_DRAW_LIMIT);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    // issue
    public static List<Lotto> issueLotto(int gameCount) {

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(Lotto.getInstance());
        }

        return lottoList;

    }

    public static Lotto checkWiningNumber(String[] winningNumberArray) {

        if (winningNumberArray.length != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        return Lotto.from(Arrays.stream(winningNumberArray)
                .map(Integer::parseInt).collect(Collectors.toList()));
    }

}

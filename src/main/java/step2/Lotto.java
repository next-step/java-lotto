package step2;

import java.util.*;

public class Lotto {

    static final int LOTTO_PRICE = 1000;
    static final int WINNING_NUMBERS_LENGTH = 6;
    static final int WINNING_NUMBERS_MIN = 1;
    static final int WINNING_NUMBERS_MAX = 45;
    static List<Integer> standardLotto = new ArrayList<>();

    public static List<Integer> generateStandardLotto() {

        for (int i = Lotto.WINNING_NUMBERS_MIN; i < Lotto.WINNING_NUMBERS_MAX + 1; i++) {
            standardLotto.add(i);
        }
        return standardLotto;
    }

    public Set<List<Integer>> purchasedLottos(int lottoCount) {
        Set<List<Integer>> collectAutoLotto = new HashSet<>();

        while (collectAutoLotto.size() < lottoCount) {
            List<Integer> shuffleLottoNumbers = generateAutoLotto();
            collectAutoLotto.add(new ArrayList<>(shuffleLottoNumbers));
        }
        return collectAutoLotto;
    }

    private List<Integer> generateAutoLotto() {
        Collections.shuffle(standardLotto);
        List<Integer> shuffleLottoNumbers = standardLotto.subList(0, 6);
        Collections.sort(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }
}

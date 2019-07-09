package step2;

import java.util.*;

public class Lotto {

    static final int LOTTO_PRICE = 1000;
    static final int WINNING_NUMBERS_LENGTH = 6;
    static final int WINNING_NUMBERS_MIN = 1;
    static final int WINNING_NUMBERS_MAX = 45;

    public List<Integer> generateStandardLotto() {
        List<Integer> standardLotto = new ArrayList<>();
        for (int i = Lotto.WINNING_NUMBERS_MIN; i < Lotto.WINNING_NUMBERS_MAX + 1; i++) {
            standardLotto.add(i);
        }
        return standardLotto;
    }

    public Set<ArrayList<Integer>> purchasedLottos(List<Integer> standardLotto, int lottoCount) {
        Set<ArrayList<Integer>> collectAutoLotto = new HashSet<>();

        while (collectAutoLotto.size() < lottoCount) {
            List<Integer> shuffleLottoNumbers = generateAutoLotto(standardLotto);
            collectAutoLotto.add(new ArrayList<>(shuffleLottoNumbers));
        }
        return collectAutoLotto;
    }

    private List<Integer> generateAutoLotto(List<Integer> standardLotto) {
        Collections.shuffle(standardLotto);
        List<Integer> shuffleLottoNumbers = standardLotto.subList(0, 6);
        Collections.sort(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }
}

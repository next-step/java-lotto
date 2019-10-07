package step3;

import java.util.*;

public class LottoGenerator {

    static final int WINNING_NUMBERS_LENGTH = 6;
    static final int BONUS_WINNING_VALID_NUMBER = 5; // 2등 당첨을 위한(보너스볼 일치), 일치해야하는 로또번호 갯수
    static private List<Integer> standardLotto = new ArrayList<>();

    public static void generateStandardLotto() {
        for (int i = Lotto.LOTTO_NUMBER_MIN; i < Lotto.LOTTO_NUMBER_MAX + 1; i++) {
            standardLotto.add(i);
        }
    }

    public static Set<Lotto> purchasedLottos(int lottoCount) {
        Set<Lotto> collectAutoLotto = new HashSet<>();

        while (collectAutoLotto.size() < lottoCount) {
            List<Integer> shuffleLottoNumbers = generateAutoLotto();
            collectAutoLotto.add(new Lotto(shuffleLottoNumbers));
        }
        return collectAutoLotto;
    }

    private static List<Integer> generateAutoLotto() {
        Collections.shuffle(standardLotto);
        List<Integer> shuffleLottoNumbers = standardLotto.subList(0, 6);
        Collections.sort(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }

}
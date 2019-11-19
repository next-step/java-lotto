package step4;

import java.util.*;

public class LottoGenerator {

    static final int WINNING_NUMBERS_LENGTH = 6;
    static final int BONUS_WINNING_VALID_NUMBER = 5; // 2등 당첨을 위한(보너스볼 일치), 일치해야하는 로또번호 갯수
    static private List<LottoNumber> standardLotto = new ArrayList<>();
    static private Scanner scan = new Scanner(System.in);

    public static void generateStandardLotto() {
        for (int i = LottoNumber.LOTTO_NUMBER_MIN; i < LottoNumber.LOTTO_NUMBER_MAX + 1; i++) {
            standardLotto.add(new LottoNumber(i));
        }
    }

    public static Set<Lotto> purchasedLottos(int lottoCount) {
        Set<Lotto> collectAutoLotto = new LinkedHashSet<>();

        while (collectAutoLotto.size() < lottoCount) {
            List<LottoNumber> shuffleLottoNumbers = generateAutoLotto();
            collectAutoLotto.add(new Lotto(shuffleLottoNumbers));
        }
        return collectAutoLotto;
    }

    private static List<LottoNumber> generateAutoLotto() {
        Collections.shuffle(standardLotto);
        List<LottoNumber> shuffleLottoNumbers = standardLotto.subList(0, 6);
        Collections.sort(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }

    public static Lotto makeManualLottos(String[] inputWinningNumbers) {
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            inputWinningNumbers[i] = inputWinningNumbers[i].trim();
        }
        List<LottoNumber> lotto = LottoNumber.splitLottoNumbers(inputWinningNumbers);

        List<LottoNumber> manualLottoNumbers = lotto.subList(0, 6);
        Collections.sort(manualLottoNumbers);
        return new Lotto(manualLottoNumbers);
    }
}
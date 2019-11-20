package step4;

import java.util.*;

public class LottoGenerator {

    public static final int WINNING_NUMBERS_LENGTH = 6;
    static private List<LottoNumber> standardLotto = new ArrayList<>();

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

    public static Lotto createLottoNumber(String[] inputWinningNumbers) {
        return new Lotto(LottoNumber.splitLottoNumbers(inputWinningNumbers));
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
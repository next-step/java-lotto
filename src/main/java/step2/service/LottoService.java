package step2.service;

import step2.domain.Number;
import step2.domain.*;
import step2.strategy.NumberGeneratorStrategy;

public class LottoService {
    public static final String BLANK = "";
    public static final String WHITE_SPACE = " ";
    public static final String COMMA = ",";
    private static final String SPLIT_REGEX = COMMA + WHITE_SPACE;
    private static final int MIN_MATCH_COUNT = 3;

    private NumberGeneratorStrategy generatorStrategy;

    private LottoService() {
    }

    public LottoService(NumberGeneratorStrategy generatorStrategy) {
        this.generatorStrategy = generatorStrategy;
    }

    public Lottos purchase(int generateCount) {
        return Lottos.purchase(generateCount, generatorStrategy);
    }

    public Lotto purchaseManualLotto(String lottoNumber) {
        return Lotto.of(splitNumbers(lottoNumber));
    }

    public WinningResult winningResult(Lottos purchasedLottos, String winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.create(splitNumbers(winningNumbers));
        return calculate(purchasedLottos, winningLotto, Number.create(bonusNumber));
    }

    private WinningResult calculate(Lottos purchasedLottos, WinningLotto winningLotto, Number bonusNumber) {
        WinningResult winningResult = WinningResult.create();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            int matchCount = lotto.match(winningLotto.getLotto());
            boolean matchBonus = lotto.matchBonus(bonusNumber);
            addWinningTypeCount(matchCount, matchBonus, winningResult);
        }
        return winningResult;
    }

    private void addWinningTypeCount(int matchCount, boolean matchBonus, WinningResult winningResult) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        WinningType type = WinningType.findBy(matchCount, matchBonus);
        winningResult.addCount(type);
    }

    private static String[] splitNumbers(String numbers) {
        validateStringNumbers(numbers);
        return numbers.split(SPLIT_REGEX);
    }

    private static void validateStringNumbers(String numbers) {
        if (BLANK.equals(numbers) || COMMA.equals(numbers)) {
            throw new IllegalArgumentException("공백 혹은 빈 값은 허용하지 않습니다.");
        }
    }
}

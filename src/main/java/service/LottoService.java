package service;

import model.*;
import util.LottoInputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int UPPER_BOUND = 45;
    private static final int LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1_000;

    private final LottoInputParser inputParser;

    public LottoService() {
        this.inputParser = new LottoInputParser(UPPER_BOUND, LOWER_BOUND, LOTTO_NUMBER_COUNT);
    }

    public Lottos create(int purchasePrice) {
        int numberOfGames = calculateNumberOfGames(purchasePrice);
        List<Integer> lottoNumberSet = inputParser.generateRangeSet();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumberSet, LOTTO_NUMBER_COUNT);

        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            list.add(lottoGenerator.randomLotto());
        }
        return new Lottos(list);
    }

    private int calculateNumberOfGames(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야합니다.");
        }
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 티켓 가격 %d의 배수여야합니다");
        }

        return purchasePrice / LOTTO_PRICE;
    }

    public LottoResult result(Lottos lottos, String winningNumbersStr) {
        List<Integer> winningNumbers = inputParser.parse(winningNumbersStr);
        Lotto winningLotto = new Lotto(winningNumbers);
        Map<Integer, Integer> placementCounts = lottos.placementCounts(winningLotto);
        return new LottoResult(LOTTO_PRICE, placementCounts);
    }
}

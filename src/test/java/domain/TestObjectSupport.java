package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestObjectSupport {
    public static List<LottoNumber> convertToLottoNumberList(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
    public static LottoNumbers createLottoNumbers() {
        return new LottoNumbers(convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    public static SelectRule createSelectRule() {
        return () -> LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    public static Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public static Lotto createSecondRankLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers(convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 7)));
        return new Lotto(lottoNumbers);
    }

    public static Lottos createLottos() {
        Lotto lotto = createLotto();
        return new Lottos(Arrays.asList(lotto, lotto, lotto));
    }

    public static Map<Rank, Integer> createRankIntegerMap() {
        Map<Rank, Integer> countByRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            countByRank.put(rank, 0);
        }
        return countByRank;
    }

    public static Winner createWinner() {
        return new Winner(createLottoNumbers(), null);
    }

    public static BonusNumber createBonusNumber() {
        return new BonusNumber(7);
    }
}

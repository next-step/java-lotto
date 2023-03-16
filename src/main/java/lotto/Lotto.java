package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoMain.lottoPrice;

public class Lotto {

    private final List<LottoNumber> lotto = new ArrayList<>();
    protected static int lottoNumberCount = 6;
    private static Map<String, Integer> rankMap = Map.of(
            "6", 1,
            "5T", 2,
            "5F", 3,
            "4", 4,
            "3", 5
    );
    private static Map<Integer, Integer> rewardMap = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000,
            0, 0
    );

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumberList) {
        validLotto(lottoNumberList);
        lotto.addAll(lottoNumberList.stream().collect(Collectors.toList()));
    }

    public Lotto() {
    }

    private void validLotto(List<LottoNumber> lotto) {
        if (lotto.size() != lottoNumberCount || lotto.size() != lotto.stream().distinct().collect(Collectors.toList()).size()) {
            throw new IllegalArgumentException("로또는 중복되지 않은 6개의 숫자로 이루어져야합니다.");
        }
    }

    public int match(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        int matchCount = (int) this.lotto.stream()
                .filter(it -> winningLotto.contains(it))
                .count();
        boolean haveBonusNumber = lotto.contains(bonusNumber);
        return rank(matchCount, haveBonusNumber);
    }

    private int rank(int matchCount, boolean haveBonusNumber) {
        String key = String.valueOf(matchCount);

        if (matchCount == 5) {
            key += (haveBonusNumber == true ? "T" : "F");
        }

        if (rankMap.containsKey(key)) {
            return rankMap.get(key);
        }
        return 0;
    }

    protected static int reward(int rank) {
        if (rank < 0 || rank > 5) {
            throw new IllegalArgumentException("등수는 0~5로 입력되어야합니다.");
        }
        return rewardMap.get(rank);
    }

    public static HashMap<String, Double> getLottoResult(List<Lotto> myLottoList, Lotto winningLotto, LottoNumber bonusNumber) {
        HashMap<String, Double> resultMap = new HashMap<>();
        List<Integer> myrankList = new ArrayList<>();
        int[] rankCount = new int[rewardMap.size()];
        int rewardSum = 0;

        myLottoList.stream().forEach(lotto -> myrankList.add(lotto.match(winningLotto.getLotto(), bonusNumber)));

        for (int i = 0; i < myrankList.size(); i++) {
            rankCount[myrankList.get(i)] += 1;
        }

        for (int i = 0; i < rankCount.length; i++) {
            rewardSum += reward(i) * rankCount[i];
            resultMap.put(String.valueOf(i), (double) rankCount[i]);
        }

        resultMap.put("PERCENTAGE", (double)rewardSum/(myLottoList.size()*lottoPrice));

        return resultMap;
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }

}

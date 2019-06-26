package edu.nextstep.step3.domain;

import edu.nextstep.step3.Rank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 00:02
 */
public class Lotto {

    private static final int MATCH_LIMIT_COUNT = 3;
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public List<Integer> getMatchCountExtractNumberFromLotteryNumber(LottoNumber lottoNumbers) {
        return getMatchCount(getMatchLottoNumberCountFromlotteryNumber(lottoNumbers));
    }

    public Map<Integer, Integer> getIncomeMatchCount(LottoNumber lottoNumbers) {
        return convertListToMap(getMatchLottoNumberCountFromlotteryNumber(lottoNumbers));
    }

    public double sumIncome(List<Integer> rank, Money money) {
        Map<Integer, Integer> count = convertListToMap(rank);
        int totalIncome = Rank.getRanks().stream()
                .mapToInt(rankNumber -> printStatisticsResult(rankNumber, count))
                .sum();

        return (double) totalIncome / (double) money.getInputMoney();
    }

    public List<LottoNumber> getExtractOfLotto() {
        return Collections.unmodifiableList(lotto);
    }

    private List<Integer> getMatchLottoNumberCountFromlotteryNumber(LottoNumber lottoNumbers) {
        return lotto.stream()
                .map(lottoNumber -> lottoNumbers.compareMatchNumberCount(lottoNumber))
                .filter(count -> count >= MATCH_LIMIT_COUNT)
                .collect(Collectors.toList());
    }

    private List<Integer> getMatchCount(List<Integer> matchCount) {
        return matchCount.stream()
                .peek(count -> Rank.matchCheck(count))
                .collect(Collectors.toList());
    }

    private Map<Integer, Integer> convertListToMap(List<Integer> rank) {
        Map<Integer, Integer> countMap = new HashMap<>();

        Rank.getRanks().forEach(rankValue -> {
            countMap.put(rankValue.getMatch(), checkValueSize(rank, rankValue.getMatch()));
        });

        return countMap;
    }

    private int checkValueSize(List<Integer> rank, int matchNumber) {
        return rank.stream()
                .filter(rankNumber -> rankNumber == matchNumber)
                .collect(Collectors.toList())
                .size();
    }

    private int printStatisticsResult(Rank rank, Map<Integer, Integer> count) {
        int rankLotteryNumber = rank.getMatch();
        int matchCount = count.containsKey(rankLotteryNumber) ? count.get(rankLotteryNumber) : 0;

        return matchCount * Rank.matchCheck(rankLotteryNumber).getLotteryMoney();
    }
}

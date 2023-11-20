package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultWinner {

    public EnumMap<Rank, Integer> countOfWinner(Lottos lottos, List<String> lastWeekWinner, String bonusNumber) {

        List<Integer> resultList = new ArrayList<>();

        EnumMap<Rank, Integer> resultMap = makeResultMap();

        for (int i = 0; i < lottos.getLottosSize(); i++) {
            resultMap = getAnswerCount(lottos.getLottoIndex(i), lastWeekWinner, bonusNumber, resultMap);
        }

        resultAdd(resultList, resultMap);
        return resultMap;
    }

    private void resultAdd(List<Integer> resultList, EnumMap<Rank, Integer> resultMap) {
        for (int i = 0; i < resultList.size(); i++) {
            getResultMap(resultList, resultMap, i);
        }
    }

    private void getResultMap(List<Integer> resultList, EnumMap<Rank, Integer> resultMap, int i) {
        validMapContainsKey(resultList, resultMap, i);
    }

    private void validMapContainsKey(List<Integer> resultList, EnumMap<Rank, Integer> resultMap, int i) {
        if (resultMap.containsKey(Rank.valueOf(resultList.get(i)))) {
            resultMap.put(Rank.valueOf(resultList.get(i)), resultMap.get(Rank.valueOf(resultList.get(i))) + 1);
        }
    }

    private EnumMap<Rank, Integer> makeResultMap() {
        EnumMap<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        for (Rank constant : Rank.values()) {
            resultMap.put(constant, 0);
        }
        return resultMap;
    }

    private EnumMap<Rank, Integer> getAnswerCount(Lotto buyLottoList, List<String> lastWeek, String bonusNumber, EnumMap<Rank, Integer> resultMap) {
        boolean checkContains;
        int answerCount = 0;
        for (String number : lastWeek) {
            checkContains = buyLottoList.getLotto().contains(Integer.parseInt(number));
            answerCount = getAnswerCalc(checkContains, answerCount);
        }

        boolean bo = buyLottoList.getLotto().contains(Integer.parseInt(bonusNumber));

        EnumMap<Rank, Integer> second = getRankSecond(resultMap, answerCount, bo);
        if (second != null) return second;

        resultMap.put(Rank.valueOf(answerCount), resultMap.get(Rank.valueOf(answerCount)) + 1);

        return resultMap;
    }

    private EnumMap<Rank, Integer> getRankSecond(EnumMap<Rank, Integer> resultMap, int answerCount, boolean bo) {
        if (answerCount == 5 && bo) {
            resultMap.put(Rank.SECOND, resultMap.get(Rank.SECOND) + 1);
            return resultMap;
        }
        return null;
    }

    private int getAnswerCalc(boolean checkContains, int answerCount) {
        if (checkContains) {
            answerCount++;
        }
        return answerCount;
    }
}

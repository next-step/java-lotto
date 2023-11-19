package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

public class ResultWinner {

    public EnumMap<Rank, Integer> countOfWinner(Lottos lottos, List<String> lastWeekWinner) {

        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < lottos.getLottosSize(); i++) {
            int answerCount = 0;
            answerCount = getAnswerCount(lottos.getLottoIndex(i), lastWeekWinner, answerCount);
            resultList.add(answerCount);
        }

        EnumMap<Rank, Integer> resultMap = makeResultMap();

        resultAdd(resultList, resultMap);
        return resultMap;
    }

    private void resultAdd(List<Integer> resultList, EnumMap<Rank, Integer> resultMap) {
        for (int i = 0; i < resultList.size(); i++) {
            getResultMap(resultList, resultMap, i);
        }
    }

    private void getResultMap(List<Integer> resultList, EnumMap<Rank, Integer> resultMap, int i) {
        if (Rank.valueOf(resultList.get(i)).isPresent()) {
            validMapContainsKey(resultList, resultMap, i);
        }
    }

    private void validMapContainsKey(List<Integer> resultList, EnumMap<Rank, Integer> resultMap, int i) {
        if (resultMap.containsKey(Rank.valueOf(resultList.get(i)).get())) {
            resultMap.put(Rank.valueOf(resultList.get(i)).get(), resultMap.get(Rank.valueOf(resultList.get(i)).get()) + 1);
        }
    }

    private EnumMap<Rank, Integer> makeResultMap() {

        EnumMap<Rank, Integer> resultMap = new EnumMap<>(Rank.class);

        for (Rank constant : Rank.values()) {
            resultMap.put(constant, 0);
        }

        return resultMap;
    }

    private int getAnswerCount(Lotto buyLottoList, List<String> lastWeek, int answerCount) {
        boolean checkContains;
        for (String number : lastWeek) {
            checkContains = buyLottoList.getLotto().contains(Integer.parseInt(number));
            answerCount = getAnswerCalc(checkContains, answerCount);
        }
        return answerCount;
    }

    private int getAnswerCalc(boolean checkContains, int answerCount) {
        if (checkContains) {
            answerCount++;
        }
        return answerCount;
    }
}

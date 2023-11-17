package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultWinner {

    static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_MIN_NUMBER = 1;


    public EnumMap<Rank, Integer> countOfWinner(List<List<Integer>> list, List<String> lastWeekWinner) {

        for (String number : lastWeekWinner) {
            validation(number);
        }

        List<Integer> resultList = new ArrayList<>();

        for (List<Integer> buyLottoList : list) {
            int answerCount = 0;
            answerCount = getAnswerCount(buyLottoList, lastWeekWinner, answerCount);
            resultList.add(answerCount);
        }

        EnumMap<Rank, Integer> resultMap = makeResultMap();

        resultAdd(resultList, resultMap);
        return resultMap;
    }

    private void validation(String number) {
        if (Integer.parseInt(number) < LOTTO_MIN_NUMBER || Integer.parseInt(number) > LOTTO_MAX_NUMBER) {
            throw new RuntimeException("유효하지 않은 로또 번호 입니다.");
        }
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

    private int getAnswerCount(List<Integer> buyLottoList, List<String> lastWeek, int answerCount) {
        boolean checkContains;
        for (String number : lastWeek) {
            checkContains = buyLottoList.contains(Integer.parseInt(number));
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

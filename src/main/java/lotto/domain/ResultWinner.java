package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class ResultWinner {

    public Map<Integer, Integer> countOfWinner(List<List<Integer>> list, String lastWeekWinner){

        List<String> lastWeek = List.of(lastWeekWinner.split(","));

        List<Integer> resultList = new ArrayList<>();

        for(List<Integer> buyLottoList : list){
            int answerCount = 0;
            answerCount = getAnswerCount(buyLottoList, lastWeek, answerCount);
            resultList.add(answerCount);
        }

        Map<Integer, Integer> resultMap = makeResultMap();

        for(int i=0; i<resultList.size(); i++){
            if(resultMap.containsKey(resultList.get(i))){
                resultMap.put(resultList.get(i), resultMap.get(resultList.get(i))+1);
            }
        }

        return resultMap;
    }

    private static Map<Integer, Integer> makeResultMap() {
        Map<Integer, Integer> resultMap = new HashMap<>();

        resultMap.put(3,0);
        resultMap.put(4,0);
        resultMap.put(5,0);
        resultMap.put(6,0);
        return resultMap;
    }

    private static int getAnswerCount(List<Integer> buyLottoList, List<String> lastWeek, int answerCount) {
        boolean checkContains;
        for(String number : lastWeek){
            checkContains = buyLottoList.contains(Integer.parseInt(number));
            answerCount = getAnswerCalc(checkContains, answerCount);
        }
        return answerCount;
    }

    private static int getAnswerCalc(boolean checkContains, int answerCount) {
        if(checkContains){
            answerCount++;
        }
        return answerCount;
    }
}

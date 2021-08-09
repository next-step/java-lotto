package step2.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int WINNING_RULE_1 = 3;
    private static final int WINNING_RULE_2 = 4;
    private static final int WINNING_RULE_3 = 5;
    private static final int WINNING_RULE_4 = 6;

    public List<Integer> getNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.getNumbers();
    }

    public List<List<Integer>> getLotto(int cnt) {
        List<List<Integer>> lottoList = new ArrayList<>();

        while (cnt-- > 0) {
            lottoList.add(getNumbers(new AutoLottoStrategy()));
        }

        return lottoList;
    }

    public Map<Integer, Integer> checkWinning(List<List<Integer>> lottoList, List<Integer> winningNoList) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(WINNING_RULE_1, 0);
        result.put(WINNING_RULE_2, 0);
        result.put(WINNING_RULE_3, 0);
        result.put(WINNING_RULE_4, 0);

        for (List<Integer> lotto : lottoList) {
            List<Integer> allNoList = combineAll(winningNoList, lotto);

            //중복 숫자 반환
            Set<Integer> duplicatedNum = getDuplicatedNum(allNoList);

            //map으로 결과 저장
            saveWinningResult(result, duplicatedNum);
        }

        return result;
    }

    private void saveWinningResult(Map<Integer, Integer> result, Set<Integer> duplicatedNum) {
        int winningNoCnt = duplicatedNum.size();
        if (result.containsKey(winningNoCnt)) {
            result.put(winningNoCnt, result.get(winningNoCnt)+1);
        }
    }

    private List<Integer> combineAll(List<Integer> winningNoList, List<Integer> lotto) {
        List<Integer> allNoList = new ArrayList<>();
        allNoList.addAll(lotto);
        allNoList.addAll(winningNoList);
        return allNoList;
    }

    private Set<Integer> getDuplicatedNum(List<Integer> allNoList) {
        Set<Integer> duplicatedNum = allNoList.stream()
                .filter(i -> Collections.frequency(allNoList, i) > 1)
                .collect(Collectors.toSet());
        return duplicatedNum;
    }
}

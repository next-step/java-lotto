package lotto_auto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumber;
    public List<LottoNumbers> lottoTotalNumberList;
    private static Map<MatchEnum, Integer> matchCntMap = new HashMap<>();


    public WinningNumber(String winningNumber, List<LottoNumbers> lottoTotalNumberList) {
        this.lottoTotalNumberList = lottoTotalNumberList;
        this.winningNumber = Arrays.stream(winningNumber.split(", "))
                .map(Integer::new)
                .collect(Collectors.toList());

        for (MatchEnum matchEnum : MatchEnum.values()) {
            matchCntMap.put(matchEnum, 0);
        }
    }

    public static Map<MatchEnum, Integer> getMatchCntMap() {
        return matchCntMap;
    }

    public void compareMagicNumber() {
        List<Integer> winningNumberList = winningNumber;

        for (int j = 0; j < lottoTotalNumberList.size(); j++) {
            match(j, winningNumberList);
        }
    }

    private void match(int j, List<Integer> winningNumberList) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            cnt = cntIncrease(j, winningNumberList, i, cnt);
        }

        for (MatchEnum matchEnum : MatchEnum.values()) {
            cntMapIncrease(matchEnum, cnt);
        }
    }

    private static void cntMapIncrease(MatchEnum matchEnum, int cnt) {
        if (cnt == matchEnum.getMatches()) {
            matchCntMap.put(matchEnum, matchCntMap.getOrDefault(matchEnum, 0) + 1);
        }
    }

    private int cntIncrease(int j, List<Integer> winningNumberList, int i, int cnt) {
        if (lottoTotalNumberList.get(j).getLottoNumbersList().contains(winningNumberList.get(i))) {
            cnt++;
        }
        return cnt;
    }
}

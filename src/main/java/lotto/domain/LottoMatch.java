package lotto.domain;


import java.util.*;

public class LottoMatch {

    List<Integer> targetNumbers;


    public LottoMatch(String input) {
        targetNumbers = new ArrayList<>();
        String[] inputs = input.split(", ");

        for (int i = 0; i < inputs.length; i++) {
            targetNumbers.add(Integer.valueOf(inputs[i]));
        }
    }

    public HashMap<LottoMatchNumber, Integer> matchResult(List<LottoTicket> myNumbers) {
        HashMap<LottoMatchNumber, Integer> results = new HashMap<>();
        results.put(LottoMatchNumber.MATCH3, 0);
        results.put(LottoMatchNumber.MATCH4, 0);
        results.put(LottoMatchNumber.MATCH5, 0);
        results.put(LottoMatchNumber.MATCH6, 0);

        for (LottoTicket myNumber : myNumbers) {
            int matchCount = myNumber.checkMatch(targetNumbers);
            inputMatchResult(matchCount, results);
        }

        return results;
    }

    private void inputMatchResult(int matchCount, HashMap<LottoMatchNumber, Integer> results) {
        for (LottoMatchNumber lottoMatchNumber : LottoMatchNumber.values()) {
            inputMatchCount(matchCount, results, lottoMatchNumber);
        }
    }

    private void inputMatchCount(int matchCount, HashMap<LottoMatchNumber, Integer> results, LottoMatchNumber lottoMatchNumber) {
        if (lottoMatchNumber.getMatchNumber() == matchCount) {
            results.put(lottoMatchNumber, results.get(lottoMatchNumber) + 1);
        }
    }

}

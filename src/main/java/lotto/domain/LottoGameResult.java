package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private List<LottoDto> lottoDtos;

    public LottoGameResult() {
        lottoDtos = new ArrayList<>();
    }

    public void doCalculateLottoResult(List<Lotto> lottos, List<Integer> winningNumbers) {

        Map<Integer, Integer> lottoDtoMap = initLottoMap();

        for (Lotto lotto : lottos) {
            int count = 0;
            count = getCount(winningNumbers, lotto, count);
            getMatchCount(lottoDtoMap, count);
        }

        lottoDtos.add(makeLottoDto(lottoDtoMap.get(THREE_MATCH), THREE_MATCH_MONEY, THREE_MATCH));
        lottoDtos.add(makeLottoDto(lottoDtoMap.get(FOUR_MATCH), FOUR_MATCH_MONEY, FOUR_MATCH));
        lottoDtos.add(makeLottoDto(lottoDtoMap.get(FIVE_MATCH), FIVE_MATCH_MONEY, FIVE_MATCH));
        lottoDtos.add(makeLottoDto(lottoDtoMap.get(SIX_MATCH), SIX_MATCH_MONEY, SIX_MATCH));
    }

    private Map<Integer, Integer> initLottoMap() {
        Map<Integer, Integer> lottoDtoMap = new HashMap<>();
        lottoDtoMap.put(THREE_MATCH, 0);
        lottoDtoMap.put(FOUR_MATCH, 0);
        lottoDtoMap.put(FIVE_MATCH, 0);
        lottoDtoMap.put(SIX_MATCH, 0);
        return lottoDtoMap;
    }

    private void getMatchCount(Map<Integer, Integer> lottoDtoMap, int count) {
        if (THREE_MATCH == count) {
            lottoDtoMap.put(THREE_MATCH, lottoDtoMap.get(THREE_MATCH)+1);
        }

        if (FOUR_MATCH == count) {
            lottoDtoMap.put(FOUR_MATCH, lottoDtoMap.get(FOUR_MATCH)+1);
        }

        if (FIVE_MATCH == count) {
            lottoDtoMap.put(FIVE_MATCH, lottoDtoMap.get(FIVE_MATCH)+1);
        }

        if (SIX_MATCH == count) {
            lottoDtoMap.put(SIX_MATCH, lottoDtoMap.get(SIX_MATCH)+1);
        }
    }

    private int getCount(List<Integer> winningNumbers, Lotto lotto, int count) {
        for (Integer number : winningNumbers) {
            if (lotto.getLottoNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private LottoDto makeLottoDto(int result, int winningMoney, int winnerCategory) {
        LottoDto lottoDto = new LottoDto(winnerCategory, winningMoney, result, winningMoney * result);
        return lottoDto;
    }

    public String getRatio(List<LottoDto> lottoDtos, int budget) {
        double totalMoney = 0;
        for (LottoDto lottoDto : lottoDtos) {
            totalMoney += lottoDto.getWinningMoney();
        }
        double result = totalMoney/(double)budget;

        return String.format("%.2f", result);
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}

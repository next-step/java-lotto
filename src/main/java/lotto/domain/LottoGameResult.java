package lotto.domain;

import lotto.enums.Rank;

import java.util.*;

public class LottoGameResult {

    private List<LottoDto> lottoDtos;

    public LottoGameResult() {
        lottoDtos = new ArrayList<>();
    }

    public void doCalculateLottoResult(BundleLotto lottos, WinningLotto winningNumbers) {
        Map<Rank, Integer> lottoRankMap = initLottoMap();
        lottoDtos = lottos.getLottoResult(lottoRankMap, winningNumbers);
        Collections.sort(lottoDtos);
    }

    private Map<Rank, Integer> initLottoMap() {
        Map<Rank, Integer> lottoDtoMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            filterRankMiss(lottoDtoMap, rank);
        }

        return lottoDtoMap;
    }

    private void filterRankMiss(Map<Rank, Integer> lottoDtoMap, Rank rank) {
        if (!rank.isMiss())
            lottoDtoMap.put(rank, 0);
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

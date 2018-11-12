package lotto.domain;

import lotto.enums.Rank;

import java.util.*;

public class LottoGameResult {

    private List<LottoDto> lottoDtos;

    public LottoGameResult() {
        lottoDtos = new ArrayList<>();
    }

    public void doCalculateLottoResult(BundleLotto lottos, WinningLotto winningNumbers, int bonusBall) {
        Map<Rank, Integer> lottoRankMap = initLottoMap();

        for (Lotto lotto : lottos.getLottos()) {
            int count = 0;
            Rank rank = getRank(winningNumbers, lotto, count, bonusBall);

            makeLottoRankMap(lottoRankMap, rank);
        }

        for (Rank key : lottoRankMap.keySet()) {
            lottoDtos.add(makeLottoDto(lottoRankMap.get(key), key));
        }

        Collections.sort(lottoDtos);
    }

    private void makeLottoRankMap(Map<Rank, Integer> lottoRankMap, Rank rank) {
        if (!rank.equals(Rank.MISS)) {
            lottoRankMap.put(rank, lottoRankMap.get(rank)+1);
        }
    }

    private Rank getRank(WinningLotto winningNumbers, Lotto lotto, int count, int bonusBall) {
        boolean matchBonus = false;
        for (Integer number : winningNumbers.getWinningNumbers()) {
            count = getCount(lotto, count, number);
        }

        if (count == 4 && lotto.getLottoNumbers().contains(bonusBall)) {
            count++;
            matchBonus = true;
        }

        return Rank.valueOf(count, matchBonus);
    }

    private int getCount(Lotto lotto, int count, Integer number) {
        if (lotto.getLottoNumbers().contains(number)) {
            count++;
        }
        return count;
    }

    private Map<Rank, Integer> initLottoMap() {
        Map<Rank, Integer> lottoDtoMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            filterRankMiss(lottoDtoMap, rank);
        }

        return lottoDtoMap;
    }

    private void filterRankMiss(Map<Rank, Integer> lottoDtoMap, Rank rank) {
        if (!rank.equals(rank.MISS))
            lottoDtoMap.put(rank, 0);
    }

    private LottoDto makeLottoDto(int countResult, Rank rank) {
        LottoDto lottoDto = new LottoDto(rank, countResult, rank.getWinningMoney() * countResult);
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

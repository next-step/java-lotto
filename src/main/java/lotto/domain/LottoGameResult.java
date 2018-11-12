package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {

    private List<LottoDto> lottoDtos;

    public LottoGameResult() {
        lottoDtos = new ArrayList<>();
    }

    public void doCalculateLottoResult(List<Lotto> lottos, WinningLotto winningNumbers, int bonusBall) {

        Map<Rank, Integer> lottoRankMap = initLottoMap();

        for (Lotto lotto : lottos) {
            int count = 0;
            Rank rank = getRank(winningNumbers, lotto, count, bonusBall);

            makeLottoRankMap(lottoRankMap, rank);
        }

        lottoDtos.add(makeLottoDto(lottoRankMap.get(Rank.FIFTH), Rank.FIFTH));
        lottoDtos.add(makeLottoDto(lottoRankMap.get(Rank.FOURTH), Rank.FOURTH));
        lottoDtos.add(makeLottoDto(lottoRankMap.get(Rank.THIRD), Rank.THIRD));
        lottoDtos.add(makeLottoDto(lottoRankMap.get(Rank.SECOND), Rank.SECOND));
        lottoDtos.add(makeLottoDto(lottoRankMap.get(Rank.FIRST), Rank.FIRST));
    }

    private void makeLottoRankMap(Map<Rank, Integer> lottoRankMap, Rank rank) {
        if (!rank.equals(Rank.MISS)) {
            lottoRankMap.put(rank, lottoRankMap.get(rank)+1);
        }
    }

    private Rank getRank(WinningLotto winningNumbers, Lotto lotto, int count, int bonusBall) {
        boolean matchBonus = false;
        for (Integer number : winningNumbers.getWinningNumbers()) {
            if (lotto.getLottoNumbers().contains(number)) {
                count++;
            }
        }

        if (count == 4 && lotto.getLottoNumbers().contains(bonusBall)) {
            count++;
            matchBonus = true;
        }

        return Rank.valueOf(count, matchBonus);
    }

    private Map<Rank, Integer> initLottoMap() {
        Map<Rank, Integer> lottoDtoMap = new HashMap<>();
        lottoDtoMap.put(Rank.FIRST, 0);
        lottoDtoMap.put(Rank.SECOND, 0);
        lottoDtoMap.put(Rank.THIRD, 0);
        lottoDtoMap.put(Rank.FOURTH, 0);
        lottoDtoMap.put(Rank.FIFTH, 0);

        return lottoDtoMap;
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

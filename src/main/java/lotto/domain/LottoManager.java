package lotto.domain;

import lotto.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    private PurchasedLottos purchasedLottos;
    private LottoNumbers winningLottoNumbers;

    LottoManager(){}

    public static LottoManager newInstance() {
        return new LottoManager();
    }

    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = price / LOTTO_PRICE;
        List<Lotto> buyingLottos = new ArrayList<>();
        for (int i = 0; i < buyingCount; i++) {
            buyLotto(selectionStrategy, buyingLottos);
        }
        this.purchasedLottos = PurchasedLottos.valueOf(buyingLottos);
    }

    private static void buyLotto(LottoNumberSelectionStrategy selectionStrategy, List<Lotto> buyingLottos) {
        buyingLottos.add(selectionStrategy.select());
    }

    public PurchasedLottosDTO listPurchasedLottos() {
        return PurchasedLottosDTO.valueOf(this.purchasedLottos);
    }

    public void decideWinningNumbers(WinningNumbersDTO winningNumbers) {
        List<Integer> winningNumberList = winningNumbers.getWinningNumbers();
        this.winningLottoNumbers = LottoNumbers.valueOf(winningNumberList);
    }

    public LottoStatisticsDTO getStatistics() {
        List<Lotto> purchasedLottos = this.purchasedLottos.value();
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = purchasedLotto.getMatchCount(this.winningLottoNumbers);
            matchCountMap.put(matchCount, matchCountMap.getOrDefault(matchCount, 0) + 1);
        }

        List<LottoReward> rewards = List.of(LottoReward.values());
        List<LottoMatchInfoDTO> matchInfoDTOs = new ArrayList<>();
        int totalReward = 0;
        for (LottoReward reward : rewards) {
            int rewardingLottoNum = matchCountMap.getOrDefault(reward.getMatchCount(), 0);
            totalReward += rewardingLottoNum * reward.getReward();
            matchInfoDTOs.add(LottoMatchInfoDTO.valueOf(reward.getMatchCount(), rewardingLottoNum, reward.getReward()));
        }
        int rewardPercentage = 100 * totalReward / (purchasedLottos.size() * LOTTO_PRICE);
        LottoMatchInfosDTO matchInfosDTO = LottoMatchInfosDTO.valueOf(matchInfoDTOs);
        return LottoStatisticsDTO.valueOf(rewardPercentage, matchInfosDTO);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}

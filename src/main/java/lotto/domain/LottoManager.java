package lotto.domain;

import lotto.dto.PurchasedLottosDTO;
import lotto.dto.LottoMatchInfoDTO;
import lotto.dto.LottoMatchInfosDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    private final PurchasedLottos purchasedLottos;
    private LottoNumbers winningLottoNumbers;

    private LottoManager() {
        purchasedLottos = PurchasedLottos.newInstance();
    }

    public static LottoManager newInstance() {
        return new LottoManager();
    }


    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = price / LOTTO_PRICE;
        for (int i = 0; i < buyingCount; i++) {
            buyLotto(i, selectionStrategy);
        }
    }

    private void buyLotto(int lottoNum, LottoNumberSelectionStrategy selectionStrategy) {
        purchasedLottos.addLotto(selectionStrategy.select(lottoNum));
    }

    public PurchasedLottosDTO listPurchasedLottos() {
        return PurchasedLottosDTO.valueOf(this.purchasedLottos);
    }

    public void decideWinningNumbers(WinningNumbersDTO winningNumbers) {
        List<Integer> winningNumberList = winningNumbers.getWinningNumbers();
        this.winningLottoNumbers = LottoNumbers.valueOf(winningNumberList);
    }

    public LottoStatisticsDTO getStatistics() {
        Map<Integer, Integer> matchCountMap = countMatchingNumbers();
        int rewardPercentage = calculateRewardPercentage(matchCountMap);
        LottoMatchInfosDTO matchInfosDTO = convertToMatchInfosDTO(matchCountMap);
        return LottoStatisticsDTO.valueOf(rewardPercentage, matchInfosDTO);
    }

    private Map<Integer, Integer> countMatchingNumbers() {
        List<Lotto> purchasedLottos = this.purchasedLottos.value();
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = purchasedLotto.getMatchCount(this.winningLottoNumbers);
            matchCountMap.put(matchCount, matchCountMap.getOrDefault(matchCount, 0) + 1);
        }
        return matchCountMap;
    }

    private int calculateRewardPercentage(Map<Integer, Integer> matchCountMap) {
        List<LottoReward> rewards = List.of(LottoReward.values());
        int totalReward = 0;
        for (LottoReward reward : rewards) {
            int rewardingLottoNum = matchCountMap.getOrDefault(reward.getMatchCount(), 0);
            totalReward += rewardingLottoNum * reward.getReward();
        }
        List<Lotto> purchasedLottos = this.purchasedLottos.value();
        return 100 * totalReward / (purchasedLottos.size() * LOTTO_PRICE);
    }

    private LottoMatchInfosDTO convertToMatchInfosDTO(Map<Integer, Integer> matchCountMap) {
        List<LottoMatchInfoDTO> matchInfoDTOs = new ArrayList<>();
        List<LottoReward> rewards = List.of(LottoReward.values());
        for (LottoReward reward : rewards) {
            int rewardingLottoNum = matchCountMap.getOrDefault(reward.getMatchCount(), 0);
            matchInfoDTOs.add(LottoMatchInfoDTO.valueOf(reward.getMatchCount(), rewardingLottoNum, reward.getReward()));
        }
        return LottoMatchInfosDTO.valueOf(matchInfoDTOs);
    }

    public PurchasedLottosDTO getPurchasedLottos() {
        return PurchasedLottosDTO.valueOf(purchasedLottos);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}

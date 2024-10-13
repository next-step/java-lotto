package lotto.domain;

import lotto.dto.LottoMatchInfoDTO;
import lotto.dto.LottoMatchInfosDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoJudge {
    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "보너스 번호가 당첨 번호와 겹칩니다.";

    private final LottoNumbers winningLottoNumbers;
    private final int bonusNumber;

    private LottoJudge(LottoNumbers winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoJudge valueOf(WinningNumbersDTO winningNumbers, int bonusNumber) {
        List<Integer> winningNumberList = winningNumbers.getWinningNumbers();
        if (winningNumberList.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
        return new LottoJudge(LottoNumbers.valueOf(winningNumberList), bonusNumber);
    }

    public LottoStatisticsDTO getStatisticsOf(LottoAgent agent) {
        List<Lotto> purchasedLottos = agent.getPurchasedLottos().getPurchasedLottos();
        Map<Integer, Integer> matchCountMap = countMatchingNumbers(purchasedLottos);
        double rewardPercentage = calculateRewardPercentage(matchCountMap, purchasedLottos);
        LottoMatchInfosDTO matchInfosDTO = convertToMatchInfosDTO(matchCountMap);
        return LottoStatisticsDTO.valueOf(rewardPercentage, matchInfosDTO);
    }

    private Map<Integer, Integer> countMatchingNumbers(List<Lotto> purchasedLottos) {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = purchasedLotto.getMatchCount(this.winningLottoNumbers);
            matchCountMap.put(matchCount, matchCountMap.getOrDefault(matchCount, 0) + 1);
        }
        return matchCountMap;
    }

    private double calculateRewardPercentage(Map<Integer, Integer> matchCountMap, List<Lotto> purchasedLottos) {
        List<LottoReward> rewards = List.of(LottoReward.values());
        int totalReward = 0;
        for (LottoReward reward : rewards) {
            int rewardingLottoNum = matchCountMap.getOrDefault(reward.getMatchCount(), 0);
            totalReward += rewardingLottoNum * reward.getReward();
        }
        return (double) totalReward / (purchasedLottos.size() * Lotto.LOTTO_PRICE);
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

    public LottoNumbers getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoJudge that = (LottoJudge) o;
        return getBonusNumber() == that.getBonusNumber() && Objects.equals(getWinningLottoNumbers(), that.getWinningLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningLottoNumbers(), getBonusNumber());
    }
}

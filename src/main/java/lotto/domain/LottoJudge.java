package lotto.domain;

import lotto.dto.LottoRewardInfoDTO;
import lotto.dto.LottoRewardInfosDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.*;

public class LottoJudge {
    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "보너스 번호가 당첨 번호와 겹칩니다.";

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    private LottoJudge(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoJudge valueOf(WinningNumbersDTO winningNumbers, int bonusNumber) {
        List<Integer> winningNumberList = winningNumbers.getWinningNumbers();
        if (winningNumberList.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
        return new LottoJudge(LottoNumbers.valueOf(winningNumberList), LottoNumber.valueOf(bonusNumber));
    }

    public LottoStatisticsDTO getStatisticsOf(LottoAgent agent) {
        List<Lotto> purchasedLottos = agent.getPurchasedLottos().getPurchasedLottos();
        Map<LottoReward, Integer> rewardCountMap = countRewards(purchasedLottos);
        double rewardPercentage = calculateRewardPercentage(rewardCountMap, purchasedLottos);
        LottoRewardInfosDTO rewardInfosDTO = convertToRewardInfosDTO(rewardCountMap);
        return LottoStatisticsDTO.valueOf(rewardPercentage, rewardInfosDTO);
    }

    private Map<LottoReward, Integer> countRewards(List<Lotto> purchasedLottos) {
        Map<LottoReward, Integer> rewardCountMap = new HashMap<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = purchasedLotto.getMatchCount(this.winningLottoNumbers);
            boolean matchBonus = purchasedLotto.hasBonusNumber(this.bonusNumber);
            LottoReward reward = LottoReward.valueOf(matchCount, matchBonus);
            rewardCountMap.put(reward, rewardCountMap.getOrDefault(reward, 0) + 1);
        }
        return rewardCountMap;
    }

    private double calculateRewardPercentage(Map<LottoReward, Integer> matchCountMap, List<Lotto> purchasedLottos) {
        int totalReward = 0;
        for (LottoReward reward : matchCountMap.keySet()) {
            int rewardCount = matchCountMap.getOrDefault(reward, 0);
            totalReward += rewardCount * reward.getReward();
        }
        return (double) totalReward / (purchasedLottos.size() * Lotto.LOTTO_PRICE);
    }

    private LottoRewardInfosDTO convertToRewardInfosDTO(Map<LottoReward, Integer> matchCountMap) {
        List<LottoRewardInfoDTO> rewardInfoDTOs = new ArrayList<>();
        for (LottoReward reward : LottoReward.values()) {
            int rewardCount = matchCountMap.getOrDefault(reward, 0);
            rewardInfoDTOs.add(LottoRewardInfoDTO.valueOf(rewardCount, reward));
        }
        return LottoRewardInfosDTO.valueOf(rewardInfoDTOs);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }

    public LottoNumber getBonusNumber() {
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

package lotto.domain.prize;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final String SEPARATOR = ",";
    private LottoNumbers winningNumbers;
    private LottoNumber bonusBall;

    private WinningLotto(String enteredWinningNumber, int bonusBall) {
        this.winningNumbers = LottoNumbers.create(convertStringToNumber(enteredWinningNumber));
        this.bonusBall = LottoNumber.create(bonusBall);
        checkBonusBallDuplicate();
    }

    public static WinningLotto create(String enteredWinningNumber, int bonusBall) {
        return new WinningLotto(enteredWinningNumber, bonusBall);
    }

    public WinningResult makeWinningResult(LottoTicket lottoTicket) {
        Map<Rank, Integer> winningCountMap = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoTicket()) {
            int matchCount = lottoNumbers.findMatchCount(this.winningNumbers);
            boolean matchBonus = lottoNumbers.haveBonusBall(this.bonusBall);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            winningCountMap.put(rank, winningCountMap.getOrDefault(rank, 0) + 1);
        }
        return WinningResult.create(winningCountMap);
    }

    private List<LottoNumber> convertStringToNumber(String enteredStringNumber) {
        String[] enteredStringNumbers = enteredStringNumber.split(SEPARATOR);
        return Arrays.stream(enteredStringNumbers)
                .map(x -> LottoNumber.create(Integer.parseInt(x.trim())))
                .collect(Collectors.toList());
    }

    private void checkBonusBallDuplicate() {
        if (this.winningNumbers.haveBonusBall(this.bonusBall)) {
            throw new IllegalArgumentException("보너스 볼이 당첨번호와 중복됩니다.");
        }
    }

}

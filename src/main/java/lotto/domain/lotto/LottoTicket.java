package lotto.domain.lotto;

import lotto.domain.prize.Rank;
import lotto.domain.prize.WinningNumbers;
import lotto.domain.prize.WinningResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private List<LottoNumbers> lottoTicket;

    private LottoTicket(int quantity) {
        checkQuantity(quantity);
        this.lottoTicket = addLottoNumbers(quantity);
    }

    private LottoTicket(List<LottoNumbers> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket create(int quantity) {
        return new LottoTicket(quantity);
    }

    public static LottoTicket createOne(List<LottoNumbers> lottoTicket) {
        return new LottoTicket(lottoTicket);
    }

    public List<LottoNumber> tellLottoNumbers(int i) {
        return lottoTicket.get(i).getLottoNumbers();
    }

    public WinningResult makeWinningResult(String enteredWinNumber, int enteredBonusBall) {
        WinningNumbers winningNumbers = WinningNumbers.create(enteredWinNumber);
        BonusBall bonusBall = BonusBall.create(enteredBonusBall, winningNumbers);
        Map<Rank, Integer> winningCountMap = new HashMap<>();
        for (LottoNumbers lottoNumbers : this.lottoTicket) {
            int matchCount = winningNumbers.findMatchCount(lottoNumbers);
            boolean matchBonus = lottoNumbers.isExist(bonusBall.getBonusBall());
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            winningCountMap.put(rank, winningCountMap.getOrDefault(rank, 0) + 1);
        }

        return WinningResult.create(winningCountMap);
    }


    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("구매 장수가 없습니다.");
        }
    }

    private List<LottoNumbers> addLottoNumbers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoNumbers.create())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }

}

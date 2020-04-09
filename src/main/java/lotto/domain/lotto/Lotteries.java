package lotto.domain.lotto;

import lotto.application.WinningLottoRequest;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.rank.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private final List<Lotto> lottery;

    private Lottery(Lottery lottery) {
        this.lottery = lottery.getLottery();
    }

    public Lottery(List<Lotto> lottery) {
        this.lottery = lottery;
    }

    public Lottery(Lottery lotteryByManual, Lottery lotteryByAuto) {
        List<Lotto> lottery = new ArrayList<>(lotteryByManual.getLottery());
        lottery.addAll(lotteryByAuto.getLottery());
        this.lottery = lottery;
    }

    public static Lottery of(Lottery lottery) {
        return new Lottery(lottery);
    }

    public static Lottery of(List<LottoNumbers> lottoNumbers) {
        return new Lottery(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public List<LottoRank> getRank(WinningLotto winningLotto) {
        return lottery.stream()
                .map(lotto -> lotto.checkRank(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    public LottoRanks matchWinningLotto(WinningLottoRequest winningLottoDto) {
        List<LottoRank> lottoRanks = lottery.stream()
                .map(lotto -> lotto.checkRank(winningLottoDto.to()))
                .collect(Collectors.toList());
        return new LottoRanks(lottoRanks);
    }

    public long getSize() {
        return lottery.stream()
                .count();
    }
}

package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.rank.WinningLotto;
import lotto.application.WinningLottoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private static final int LOTTO_MAX_SIZE = 5;

    private final List<Lotto> lottery;

    private Lottery(List<Lotto> lottery) {
        this.lottery = lottery;
    }

    private Lottery(Lottery lottery) {
        this.lottery = lottery.getLottery();
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
        int offset = lottoNumbers.size() / LOTTO_MAX_SIZE;

        List<Lotto> lottery = new ArrayList<>();
        for (int i = 0; i <= offset; i++) {
            lottery.add(getLotto(lottoNumbers, i));
        }
        return new Lottery(lottery);
    }

    public List<LottoRank> getRank(WinningLotto winningLotto) {
        return lottery.stream()
                .map(lotto -> lotto.checkRank(winningLotto))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLotterySources() {
        return lottery.stream()
                .map(lotto -> lotto.getLottoSources())
                .collect(Collectors.toList())
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    public long getSize() {
        return lottery.stream()
                .map(Lotto::getLottoLines)
                .flatMap(List::stream)
                .count();
    }

    private static Lotto getLotto(List<LottoNumbers> lottoNumbers, int offset) {
        List<LottoLine> lottoLines = lottoNumbers.stream()
                .skip(LOTTO_MAX_SIZE * offset)
                .limit(LOTTO_MAX_SIZE)
                .map(LottoLine::new)
                .collect(Collectors.toList());
        return new Lotto(lottoLines);
    }

    public LottoRanks matchWinningLotto(WinningLottoRequest winningLottoDto) {
        List<LottoRank> lottoRanks = lottery.stream()
                .map(lotto -> lotto.checkRank(winningLottoDto.to()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return new LottoRanks(lottoRanks);
    }
}

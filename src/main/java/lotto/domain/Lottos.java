package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;

    private final List<LottoNumbers> lottos;
    private final UserAmount userAmount;

    public Lottos(int userAmount, String lottoOfUser) {
        this.userAmount = new UserAmount(userAmount);
        this.lottos = getRandomLottoNumbersWith(toLottoNumbers(lottoOfUser));
    }

    protected Lottos(List<LottoNumbers> lottos) {
        this.userAmount = new UserAmount(lottos);
        this.lottos = lottos;
    }

    private static List<LottoNumbers> toLottoNumbers(String lottoOfUser) {
        return Arrays.stream(lottoOfUser.split("\n"))
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }

    public int length() {
        return this.lottos.size();
    }

    public void print() {
        this.lottos.stream()
                .map(LottoNumbers::toString)
                .forEach(System.out::println);
    }

    public double getRevenueRate(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        int sum = this.getMatchNumberCounts(lottoNumbers).stream()
                .map(it -> Rank.valueOf(it, lottoNumbers.contains(bonusBall)))
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum)
                .orElseThrow(IllegalArgumentException::new);

        return this.userAmount.calculateRevenue(sum);
    }

    public int getRankCount(WinningLotto winningLotto, Rank rank) {
        LottoNumbers winningLottoNumbers = winningLotto.getWinningLottoNumbers();
        LottoNumber bonusBall = winningLotto.getBonusBall();

        return (int) this.lottos.stream()
                .map(it -> Rank.valueOf(it.getMatchNumberCount(winningLottoNumbers), it.contains(bonusBall)))
                .filter(it -> it == rank)
                .count();
    }

    private List<LottoNumbers> getRandomLottoNumbersWith(List<LottoNumbers> userInputLottos) {
        List<LottoNumbers> randomLottoNumbers = IntStream.range(
                        START_INCLUSIVE, this.userAmount.getRandomLottoSize(userInputLottos)
                )
                .mapToObj(it -> LottoNumbers.ofRandom())
                .collect(Collectors.toList());

        return attach(userInputLottos, randomLottoNumbers);
    }

    private List<LottoNumbers> attach(List<LottoNumbers> userInputLottos, List<LottoNumbers> randomLottoNumbers) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(userInputLottos);
        lottoNumbers.addAll(randomLottoNumbers);

        return lottoNumbers;
    }

    private List<Integer> getMatchNumberCounts(LottoNumbers lottos) {
        return this.lottos.stream()
                .map(lottos::getMatchNumberCount)
                .collect(Collectors.toList());
    }

}

package lottogame.domain;

public class WinningLottos {

    private final Lottos lottos;
    private final LottoNumber bonusNumber;

    private WinningLottos(Numbers numbers, Number bonusNumber) {
        this.lottos = Lottos.from(numbers);
        this.bonusNumber =  new LottoNumber(bonusNumber);
    }

    public static WinningLottos of(Numbers numbers, Number bonusNumber) {
        validate(numbers, bonusNumber);
        return new WinningLottos(numbers, bonusNumber);
    }

    public Rank checkRank(Lottos lottos) {
        return Rank.find(match(lottos), matchBonusNumber(lottos));
    }

    public Number calculatePrize(Lottos lottos) {
        return Number.from(Rank.findPrize(match(lottos), matchBonusNumber(lottos)));
    }

    public int size() {
        return lottos.size();
    }

    private boolean matchBonusNumber(Lottos lottos) {
        return lottos.match(bonusNumber);
    }

    private static void validate(Numbers numbers, Number number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복 될수 없습니다.");
        }
    }

    private int match(Lottos lottos) {
        return this.lottos.match(lottos);
    }
}

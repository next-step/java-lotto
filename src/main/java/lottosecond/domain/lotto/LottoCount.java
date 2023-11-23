package lottosecond.domain.lotto;

public class LottoCount {

    private final int lottoCount;

    private LottoCount(int lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("로또 개수가 0보다 작을 수 없습니다.");
        }

        this.lottoCount = lottoCount;
    }

    public static LottoCount from(int targetLottoCount, int totalLottoCount) {
        if (targetLottoCount > totalLottoCount) {
            throw new IllegalArgumentException("로또 개수가 총 구매 로또 수보다 클 수 없습니다.");
        }

        return new LottoCount(targetLottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}

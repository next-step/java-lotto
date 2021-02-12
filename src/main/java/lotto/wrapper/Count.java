package lotto.wrapper;

public class Count {
    private int count;

    public Count(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    public void countUp() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static Count split(Count lottos, Count lottosManual) {
        int randomCount = lottos.getCount() - lottosManual.getCount();
        return new Count(randomCount);
    }
    public static Count sum(Count lottosManual, Count lottosRandom) {
        int lottoCount = lottosManual.getCount() + lottosRandom.getCount();
        return new Count(lottoCount);
    }
}

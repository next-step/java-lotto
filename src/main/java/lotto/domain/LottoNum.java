package lotto.domain;

public class LottoNum implements Comparable<LottoNum> {
    private final int num;

    public LottoNum(int num) {
        validate(num);
        this.num = num;
    }

    private void validate(int num) {
        if (num <= 0 || num >= 46) {
            throw new IllegalArgumentException("로또 숫자는 1~45까지만 가능합니다.");
        }
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(LottoNum o) {
        return this.num - o.num;
    }
}

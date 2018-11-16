package lotto;

public class LottoNo implements Comparable<LottoNo> {
    private Integer number;

    public LottoNo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNo no) {
        return this.number.compareTo(no.getNumber());
    }
}

package lotto.domain;

public class LottoNo {
    private int number;

    public LottoNo() {
    }

    public LottoNo(String number) {
        this.number = Integer.parseInt(number.trim());
    }

    public LottoNo(int number) {
        this.number = number;
    }

    public int getLottoNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == (Integer)obj;
    }
}

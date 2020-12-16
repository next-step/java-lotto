package lotto.domain;

public enum LottoMagicNumber {
    START(1),
    END(45),
    NUMBER_COUNT(6),
    BASE_INDEX(0);

    private final int magicNumber;

    LottoMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int get() {
        return magicNumber;
    }
}

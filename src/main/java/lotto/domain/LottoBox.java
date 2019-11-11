package lotto.domain;

public class LottoBox {
    private static final int SUBSTRING_FROM_INDEX = 0;
    private static final int SUBSTRING_TO_INDEX = 6;
    private static LottoNumbers defaultNumbers = LottoNumbers.defaultNumbers();

    public static Lotto generateLotto() {
        defaultNumbers.shuffle();
        return new Lotto(defaultNumbers.subNumbers(SUBSTRING_FROM_INDEX, SUBSTRING_TO_INDEX));
    }

    public static Lotto parseNumberString(String numberString) {
        return new Lotto(LottoNumbers.of(numberString));
    }
}

package lotto;

public enum LottoType {
    ZERO(0, 0, 0, "0개 일치 (0)원"),
    ONE(1, 0, 0, "1개 일치 (0)원"),
    TWO(2, 0, 0, "2개 일치 (0)원"),
    THREE(3, 0, 5000, "3개 일치 (5000원)"),
    FOUR(4, 0, 50000, "4개 일치 (50000원)"),
    FIVE(5, 0, 1500000, "5개 일치 (1500000원)"),
    FIVE_BONUS(5, 1, 30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    SIX(6, 0, 2000000000, "6개 일치 (2000000000원)");

    private int num;
    private int bonusNum;
    private int price;

    private String printString;

    private static final LottoType[] LOTTO_TYPES = LottoType.values();


    LottoType(int matchedNumbers, int bonusWinNumber, int i2, String printString) {
        this.num = matchedNumbers;
        this.bonusNum = bonusWinNumber;
        this.price = i2;
        this.printString = printString;
    }

    public int getPriceMultiply(Long cnt) {
        return (int) (price * cnt);
    }

    public String getPrintString() {
        return this.printString;
    }

    public static LottoType of(int num, int bonusNum) {
        int data = 0;

        if (num == 5 && bonusNum == 1) {
            data++;
        }
        //System.out.println(num+ "  "+data);
        return LOTTO_TYPES[num + data];
    }


}

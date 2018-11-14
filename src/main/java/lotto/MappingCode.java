package lotto;


import static lotto.LottoCommonUtil.ConvertMoneyFromString;

public enum MappingCode {
    THREE(3, "5_000"),
    FOUR(4, "50_000"),
    FIVE(5, "1_500_000"),
    SIX(6, "2_000_000_000");

    private final int count;
    private final String prizes;

    MappingCode(int count, String prizes){
        this.count = count;
        this.prizes = prizes;
    }

    public int calculateTotalPrize(int count) {
        int prize = ConvertMoneyFromString(this.prizes);
        return count * prize;
    }
    public boolean matchCode(int count){
            if(this.count == count){
                return true;
            }

        return false;
    }
}

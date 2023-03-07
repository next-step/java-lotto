package lotto;

public enum LottoType {
    ZERO(0,0,0),
    ONE(1,0,0),
    TWO(2,0,0),
    THREE(3,0,5000),
    FOUR(4,0,50000),
    FIVE(5,0,1500000),
    FIVE_BONUS(5,1,30000000),
    SIX(6,0,2000000000);

    private int num;
    private int bonusNum;
    private int price;

    private static final LottoType[] LOTTO_TYPES = LottoType.values();


    LottoType(int i, int i1, int i2) {
        this.num = i;
        this.bonusNum = i1;
        this.price = i2;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public static  LottoType of(int num, int bonusNum){
        int data = 0;

        if(num == 5 && bonusNum == 1 ){
            data++;
        }
        System.out.println(num+ "  "+data);
        return LOTTO_TYPES[num  + data];
    }


}

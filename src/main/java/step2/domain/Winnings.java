package step2.domain;

public enum Winnings {
    FIRST(6,2000000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000),
    NOTHING(0,0);

    private int matchCount;
    private int price;

    Winnings(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static int find(int count){
        for(Winnings WIN : values()){
            if(WIN.matchCount == count){
                return WIN.price;
            }
        }
        return NOTHING.price;
    }
}

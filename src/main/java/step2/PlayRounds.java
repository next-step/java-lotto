package step2;

public class PlayRounds {

    private static final int LOTTO_PRICE = 1000;

    private PlayRounds() {
    }

    public static int getPlayRounds(int price){
        return price/LOTTO_PRICE;
    }


}

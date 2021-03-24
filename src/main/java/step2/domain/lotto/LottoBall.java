package step2.domain.lotto;

import java.util.Random;

public class LottoBall {
    private static int LOWER_BOUND = 1;
    private static int UPPER_BOUND = 45;

    private static Random random = new Random();

    int number;

    public LottoBall(){
        this(number());
    }

    public LottoBall(int number){
        if(!valid(number)){
            throw new IllegalArgumentException("음수는 허용하지 않습니다");
        }
        this.number = number;
    }

    private static int number(){
        return random.nextInt(UPPER_BOUND+1);
    }

    private boolean valid(int number){
        return number>=LOWER_BOUND && number<=UPPER_BOUND;
    }
}

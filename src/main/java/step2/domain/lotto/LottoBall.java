package step2.domain.lotto;

public class LottoBall {
    int number;

    public LottoBall(int number){
        if(!valid(number)){
            throw new IllegalArgumentException("음수는 허용하지 않습니다");
        }
        this.number = number;
    }
}

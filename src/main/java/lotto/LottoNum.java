package lotto;

public class LottoNum {

    private final int num;

    public LottoNum(int num){
        validate(num);
        this.num = num;
    }

    private void validate(int num) {
        if(num <= 0 || num >= 46){
            throw new IllegalArgumentException("lotto num is 1 to 45");
        }
    }

}

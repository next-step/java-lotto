package domain.wrapper;

public class LottoNo extends PlusNumber {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    public LottoNo(int number) {
        super(number);
        if(LOTTO_MIN_NUM < number || number < LOTTO_MAX_NUM ){
            throw new RuntimeException("로또 범위를 벗어났습니다.");
        }
    }

}

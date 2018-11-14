package domain.wrapper;

public abstract class PlusNumber {
    public static final int LOTTO_PRICE = 1000;
    private int number;

    public PlusNumber(int number) {
        if(number < 0){
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        this.number = number;
    }

    public boolean equalsNumber(PlusNumber obj) {
        return this.number == obj.number;
    }

    public int subtract(PlusNumber obj){
        this.number -=  obj.number;
        if(number < 0){
            throw new RuntimeException("음수가 될 수 없습니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}

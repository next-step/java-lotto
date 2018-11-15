package domain.wrapper;

public abstract class PlusNumber {
    public static final int LOTTO_PRICE = 1_000;
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

        if(number < obj.number){
            throw new RuntimeException("음수가 될 수 없습니다.");
        }
        this.number -=  obj.number;
        return number;
    }

    public int getNumber() {
        return number;
    }

    public double divide(PlusNumber obj){
        if(obj.number == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return this.number /=  (double)obj.number;
    }

    @Override
    public String toString() {
        return number+"";
    }
}

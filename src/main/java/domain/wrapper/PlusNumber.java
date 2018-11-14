package domain.wrapper;

public abstract class PlusNumber {
    private int number;
    public PlusNumber(){}

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

    public int addition(PlusNumber obj){
        this.number +=  obj.number;
        return number;
    }

    public double division(PlusNumber obj){
        this.number /=  (double)obj.number;
        return (double)number;
    }

    public int multiply(PlusNumber obj){
        this.number *=  obj.number;
        return number;
    }




}

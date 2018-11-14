package domain.wrapper;

public class Money extends PlusNumber{
    public Money(int number) {
        super(number);
    }

    @Override
    public boolean equalsNumber(PlusNumber obj) {
        return super.equalsNumber(obj);
    }

    @Override
    public int subtract(PlusNumber obj) {
        return super.subtract(obj);
    }

    public int getCount(){
        return super.getNumber() / LOTTO_PRICE;
    }
}

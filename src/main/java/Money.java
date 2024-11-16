public class Money {
    private final int value;

    public Money(){
        this(0);
    }

    public Money(int value) {
        this.value = value;
    }

    public int AvailLottoCount(){
        return this.value / 1000;
    }

    @Override
    public boolean equals(Object obj) {
        return this.value == ((Money) obj).value;
    }
}

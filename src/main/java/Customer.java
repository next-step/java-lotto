public class Customer {
    private Money money;

    public Customer(int money){
        this.money = new Money(money);
    }

    public int getMoney(){
        return this.money.getMoney();
    }
}

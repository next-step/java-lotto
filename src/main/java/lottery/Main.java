package lottery;

public class Main {

	public static void main(String[] args) {

		Buyer buyer = Buyer.of(Money.won(10000L));
		Store store = new Store();

		LotteryInfoCenter lotteryInfoCenter = new LotteryInfoCenter();
		buyer.buyTicket(store);

		buyer.lotteryTickets(); // TODO View Class

		if (buyer.hasTickets()){
			// buyer.checkTicket(lotteryInfoCenter);
		}



	}
}

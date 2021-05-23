package lottery;

public class Main {

	public static void main(String[] args) {

		Buyer buyer = Buyer.of(Money.won(10000L));
		Store store = new Store();
		InfoCenter infoCenter = new InfoCenter();

		Result result = Result.NONE;
		buyer.buyTicket(store);

		// TODO show tickerNumbers View Class
		// TODO show ticketResult
		// TODO separate View
		if (buyer.hasTickets()){
			result = buyer.checkTicket(infoCenter);
		}

		result.getTotalMatchNumber().forEach(
			(match, count) -> System.out.printf("%d개 일치 (%d원)", count, match.money().amount())
		);
		System.out.printf("총 수익률은  %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.getTotalYield(buyer.money()));
	}
}

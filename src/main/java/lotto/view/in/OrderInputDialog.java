package lotto.view.in;

import common.ExpressionSplitter;
import lotto.model.LottoNumberSet;
import lotto.model.LottoOrder;
import lotto.view.out.MessagePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 주문서 작성 대화창 컴포넌트
 */
public class OrderInputDialog {

	private MessagePrinter printer;
	private InputReader reader;

	/**
	 * 메세지 출력, 입력값 처리 의존성을 주입받아 초기화
	 * @param printer 사용자에게 메세지를 전달하는 출력기
	 * @param reader 사용자가 입력한 데이터를 처리하는 입력기
	 */
	public OrderInputDialog(MessagePrinter printer, InputReader reader){
		this.printer = printer;
		this.reader = reader;
	}

	/**
	 * 주문서 생성 메서드
	 * @return 로또구입금액, 수동지정번호 등 구매에 필요한 정보가 포함된 주문서 반환
	 */
	public LottoOrder makeOrder(){
		this.printer.print("구입금액을 입력해 주세요.");
		int investment = Integer.parseInt(reader.read());

		this.printer.print("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualTicketCount = Integer.parseInt(reader.read());

		List<LottoNumberSet> manualNumberSets = this.processManualInput(manualTicketCount);

		return new LottoOrder(investment, manualNumberSets);
	}

	/**
	 * 지정된 횟수만큼 수동입력 처리
	 * @param manualTicketCount	수동지정 구매 매수
	 * @return 수동으로 지정된 로또번호 목록 반환
	 */
	private List<LottoNumberSet> processManualInput(int manualTicketCount) {
		if(manualTicketCount <= 0){
			return null;
		}

		List<LottoNumberSet> manualNumberSets = new ArrayList<>();
		this.printer.print("수동으로 구매할 번호를 입력해 주세요.");

		while(manualTicketCount > 0){
			String inputValue = reader.read();
			LottoNumberSet numbers = LottoNumberSet.of(new ExpressionSplitter(inputValue).split());
			manualNumberSets.add(numbers);
			manualTicketCount--;
		}

		return manualNumberSets;
	}
}

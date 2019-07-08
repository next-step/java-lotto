package lotto.model;

/**
 * 로또 구입에 필요한 정보를 관리하는 개체
 * 수동번호, 주문 가능 금액 초과등을 판단
 */
public class LottoOrder {

	private static final int PRICE_OF_TICKET = 1000;
	
	/**
	 * 주문서 생성
	 * @param investment 투자금(구입금액)
	 * @param manualCount 수동입력 구매 수
	 */
	public LottoOrder(int investment, int manualCount) {
		if(manualCount * PRICE_OF_TICKET > investment){
			throw new IllegalArgumentException();
		}
		
		
	}

	/**
	 * 주문서가 유효한 상태인지 확인
	 * 수동구매 요청 수에 맞게 입력되었는지 검사
	 * @return 주문서 생성조건에 맞게 준비되었다면 true 반환
	 */
	public boolean verify() {
		return true;
	}

	public int getBalance() {
		return 0;
	}
}

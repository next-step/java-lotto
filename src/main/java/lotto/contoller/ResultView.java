package lotto.contoller;

import lotto.domain.Customer;
import lotto.domain.Lottos;


public class ResultView {

    public ResultView() {

    }

    // NOTE: 로또 findLottoList()함수로 리스트를 반환하는게 맞는걸까요?
    //       customer 객체에 메시지를 보내서 그 안에서 출력하는게 맞는걸까요?
    //       객체 안에서 처리하면 프린트를 하는 대상에 대한 역할이 애매해지는거 같아서 질문드립니다!
    public void printLottos(Customer customer) {
        Lottos lottoList = customer.findLottoList();
        System.out.println(lottoList);

/**
 *      customer.printLottoList() {
 *          System.out.println(lottoList);
 *      }
 *
 */

    }
}

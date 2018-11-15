import java.util.Set;

public class LottoMain {
    class 로또{}
    class 당첨로또{}

    interface 발행{}
    class 자동발행 implements 발행{
        Set<로또> 로또리스트생성(){

        }
    }
    class 수동발행 implements 발행{
        Set<로또> 로또리스트생성(Set<로또> 로또리스트){

        }
    }

    class 로또번호매칭{
        void 로또매칭(Set<로또> 이번주번호){
            //이번주 번호랑
            //발행된 리스트랑 비
        }
    }

    class 계산_로또수익률{}

    interface 계산{}
    class 로또수익률 implements 계산{}

    //구체적인 클래스가 아니라 행위에만 의존해야함.
}

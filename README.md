# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## step1 기능분해
* [X] 사용자 null, 공백만 입력하는 경우 exception을 발생시킨다.
* [X] 사칙연산으로 입력받을 수 있는 문자열은 +, -, *, / 이다.
* [X] 숫자를 하나 덜 입력하는 경우 exception을 발생시킨다.
* [X] 사칙연산 계산이 가능한 형태로 입력하지 않을 경우 오류를 발생시킨다.
* [X] 입력 값 끝이 숫자가 아닌 경우 오류가 발생한다.
* [X] 덧셈, 뺄셈, 곱셈, 나눗셈 기능이 가능하다.
* [X] 숫자와 사칙연산 사이에 공백이 없는 경우 Exception을 발생시킨다.
* [X] 사칙연산 계산을 들어오는 순서대로 계산한다.
추가 요구사항
* [X] 매직넘버 상수화 하기
* [X] 매소드 파라미터 3개 이상인 경우 2개 이하로 줄여보기
* [X] 열거타입과 람다식을 활용해 행위를 추상화 해보기

## step2 기능분해
* [X] 고객에게 로또 구입 금액을 입력받는다. 
* [X] 로또 한장의 가격은 1000원으로, 구입 금액에 맞게 로또 장수를 계산해 출력한다.
* [X] 구입한 티켓 갯수에 맞춰 로또를 생성한다.
* [X] 로또 생성은 Collections.shuffle() 메소드를 활용한다.
* [X] 로또 번호 출력은 Collections.sort()를 활용한다.
* [X] ArrayList()의 Contains 함수를 활용하여 당첨 번호를 체크한다.
* [X] 당첨 번호를 inputView에서 입력받는다.
* [X] 당첨 번호를 6개 미만으로 입력하는 경우 Exception이 발생한다.
* [X] 당첨 번호와 각 로또 번호를 매칭해 당첨 결과를 출력한다.
* [X] 구입 금액 대비 총 당첨금액 수익률을 계산해 출력한다.

## TODO, step2 보완점
* [X] LottoNumber을 활용해 원시값을 분리해본다. (winninglotto)
* [X] 로또번호가 1~45 사이 값이 아닌 경우 Exception 발생한다.
* [X] Lottoprice를 어떻게 관리할지
* [X] 현재 public api에 대한 테스트 케이스 채우기
* [X] '오류' 대신 Exception 용어 활용 
* [X] 래퍼 클래스 대신 Primitive 타입사용하기
* [X] 테스트코드 클래스 패키지 명칭 및 구조 보완하기
* [X] userLotto -> service, domain 성격 명확히 재구성하기
* [X] service/domain 성격에 맞는 클래스 명칭 정하기
* [X] 이율계산식 OCP, DIP 가능하도록 보완
* [X] 재사용가능한 전역변수 캐싱 활용하기 -> Lotto 통합
* [X] 언더바를 활용한 구독성 높이기
* [X] 함수형 인터페이스 활용해보기..ㅠㅠ (Prize)
* [X] 로또번호 List->Set으로 변경하기

## step3 -> step2 추가보완점
* [X] 불필요한 주석 지우기
* [X] 의존관계 주입을 위한 config layer 생성
* [X] kor 입력 대신 국가코드 열거타입으로 변경
* [X] enum 마지막 콤마삭제
* [X] 생성자 안에는 최대한 비즈니스 로직을 제거하고 필요한 경우 정적 팩토리 함수 사용하가(Lotto)
* [X] 열거타입 map 사용할 때 hashMap-> enumMap 활용해보기
* [X] 구매가능 티켓 리턴 메소드 명칭 buyTickets 대신 더 명확하게 바꿔보기
* [X] 객체화가 필요없는 싱글턴 객체 ->  생성자 제한
* [X] 예외발생 대신 던져진다(throw)는 표현으로 변경하기
* [X] 1등 이외의 등수 테스트
* [X] 로또 가격 이하 금액 input 테스트
* [X] 로또번호도 미리 1~45까지 만들어서 보관해두고, 정적 팩토리 함수로 미리 만들어둔 로또 번호 객체를 반환해보기(valueOf)

## step3 기능분해
* [X] 2등을 위해 추가 번호(보너스번호)를 입력받을 수 있다.
* [X] 보너스번호가 일치하는 경우 true가 리턴된다.
* [X] 보너스를 포함한 winning 번호와 로또번호가 매칭되는 만큼 카운트가 증가한다.
* [X] 5개 일치 + 보너스볼을 맞추는 경우 2등이 된다. 
* [X] 당첨 통계에 2등도 추가해야 한다.

## step3 보완점
* [X] Lotto 생성자 생성시 list가 아닌 set으로 생성하기
* [X] 테스트코드에서만 사용하는 프로덕션 코드 제거
* [X] 가변인수 관련 내용 확인하기
* [X] 생성자에 있는 비즈니스 로직(안티패턴) 제거, 정적팩토리메소드 확인
* [X] stream size 함수 활용
* [X] 스트림함수 contains 활용해서 역할 위임하기
* [X] 한줄 분기문{}, IDE에 의한 자동생성된 형태여도 주의하기! (가독성, 일관성 저하)
* [X] dot(.)이 너무 많이 사용되는 경우 지역변수 활용하기
* [X] for문 안에 if문, indent 규칙 검토
* [X] NPE 위험이 있는 경우 반대로 표현하기
* [X] sys.out이 많아지는 경우 다른 방법(stringbuilder 등) 활용하기
* [X] 로또 상금 열거 타입의 매치카운트 정상적인 값 반환 테스트
* [X] 로또 상금 열거 타입의 유효성 검증 실패 테스트
* [X] 당첨 로또의 유효성 검증 실패 테스트
* [X] UserLottoRepository의 사용하지 않는 생성자 제거\

## step4 기능분해
* [X] 구입 금액, 수동 구매 로또 수, 수동 생성 번호를 입력하도록 한다.
* [X] 사용자가 수동으로 구매할 로또 수를 입력할 수 있다.
* [X] 사용자가 총 구매 가능 로또 수를 초과 입력하는 경우 Exception throw
* [X] 사용자가 수동으로 추첨 번호를 입력할 수 있다.
* [X] 사용자가 숫자를 6개 미만으로 입력하는 경우 Exception throw
* [X] 사용자가 숫자를 6개를 초과 입력하는 경우 Exception throw
* [X] 사용자가 숫자를 중복 입력하는 경우 Exception throw
* [X] 전체 매수 중 수동으로 구매하는 매수를 뺀만큼 자동으로 로또티켓를 생성한다.

## step3 추가 보완점
* [ ] Spring Configuration class Bean 등록하는 내용 확인해보기
* [X] 인라인으로 줄이기!
* [X] exception 발생 ㅠ..습관.. throw로 쓰기!!!
* [X] 로또번호 valueOf로 캐싱활용⭐️️️️
* [X] 여러번 map 활용하는 경우 정적팩토리 함수 활용 (정적 팩토리 함수 활용 연습)
  * 단순 값 할당과 간단한 기본값 세팅은 점층적 생성자 / 값 가공으로 객체에 어울리게 재생산 하는 경우는 정적 팩토리 메소드!
* [X] 최초 생성한 뒤에 변경되지 않는 변수인 경우 final 붙이기
* [ ] repository class 인스턴스변수 -> 정적 변수!

## step4 보완
* [X] Lottonumber 캐싱
* [X] bonusNumber 타입 변경
* [ ] config 파일 위치 재설정
* [ ] 메소드 안 15줄 이상 되는 경우 리팩토링
* [ ] 점층적 생성자 안에서 값을 세팅 이상인 경우 체크하고 안티패턴 제거

## TODO
* [ ] Lotto 인터페이스를 활용해 Winning, Auto, Manual 클래스 생성해보기


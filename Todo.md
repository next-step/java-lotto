# Step1

## Todo
- 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)
- 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)

## Done
- 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- 덧셈("1 + 2" => 3)
- 뺄셈("1 - 2" => -1)
- 곱셈("1 * 3" => 3)
- 나눗셈("4 / 2" => 2)x
- 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)

## Done
- [x] 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- [x] 덧셈("1 + 2" => 3)
- [x] 뺄셈("1 - 2" => -1)
- [x] 곱셈("1 * 3" => 3)
- [x] 나눗셈("4 / 2" => 2)x
- [x] 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)
- [x] 정의된 연산자 이외라면 예외("1 ( 2" => IllegalArgumentException)
- [x] 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)
- [x] 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)
- [x] intelliJ newLine 적용
- [x] Todo.md에 md 문법 적용
- [x] Operator의 toOperator를 stream 써서 리팩토링
- [x] IntBinaryOperator를 Functional Interface를 사용해서 직접 구현하는 행태로 변경
- [x] CalculateHandler를 "문자열이 숫자인지 연산자인지 판단/왼쪽부터 순서대로 계산" 2가지 책임을 가진 클래스로 분리


# Step2

## Todo

## Done
- [X] Cash - 1000보다 작으면 예외(1000 => IllegalArgumentException, 0 => IllegalArgumentException)
- [X] Cash - 1000으로 나눈 몫을 반환(14000 => 14, 20123 => 20)
- [X] Match - 2 개의 배열 중에 하나라도 null이면 예외((null,null) => IllegalArgumentException, (null,empty) => IllegalArgumentException)
- [X] Match - 두 개의 배열을 비교하여 일치하는 개수 반환((1,2,3],[1,2,3]) => 3, ([1,0,4],[1,2,3]) => 1, ([1],[1,2,3,4] =>1))
- [X] Profit - 수익금 계산(1 => 0, 3 => 5000, 6 => 2000000000)
- [X] Profit - 누적 수익금 계산(3,3,4,6 => 2000060000)
- [X] Profit - 내가 낸 금액과 수익금을 통해서 수익률 계산((14000, 5000) => 0.35, (2000, 2000000000) => 1000000, (10, 0) => 0)
- [X] LottoGenerator - 1 ~ 45 사이의 중복되지 않고 오름차순으로 정렬된 6개 정수 생성(1,2,3,4,5,6)
- [X] MatchCache - 일치 개수 저장(1 -> [1,0,0,0,0,0], 3 -> 1 -> [0,0,1,0,0,0], 5 -> 1 -> [0,0,0,0,1,0])
- [X] MatchCache - 일치 개수 누적 저장(1,1,3,3,3,5 -> [2,0,3,0,1,0])
- [X] LottoClient - 출력("구입금액을 입력해 주세요.")
- [X] LottoClient - 숫자 입력
- [X] LottoClient - 구매한 로또 개수 출력("15개를 구매했습니다.")
- [X] LottoClient - 구매한 로또 개수만큼 6자리 로또 번호 출력("[8, 21, 23, 41, 42, 43]")
- [X] LottoClient - 출력("지난 주 당첨 번호를 입력해 주세요.")
- [X] LottoClient - 입력("1, 2, 3, 4, 5, 6")
- [X] LottoClient - 출력("당첨 통계")
- [X] LottoClient - 출력("---------")
- [X] LottoClient - 일치 금액 + 일치 개수 출력("3개 일치 (5000원)- 1개")
- [X] LottoClient - 총 수익률 출력("총 수익률은 0.35입니다.")
- [X] 코드 리뷰 적용 - Todo의 기능 요구사항들 테스트 코드 DisplayName으로 옮기기
- [X] 코드 리뷰 적용 - Cash 매직넘버 분리 및 상태값 불변 변수로 수정
- [X] 코드 리뷰 적용 - LottoPricing 에서 matchCount에 따른 value 값 캐싱
- [X] 코드 리뷰 적용 - LottoGroup 2차원 배열 tickets 2개의 일급 컬렉션으로 분(List<Integer> -> LottoNumber, List<LottoNumber> -> Lotto) 
- [X] 코드 리뷰 적용 d- MatchCacheTest 내에서 system 출력으로 검증한 부분 수정
- [X] 코드 리뷰 적용 - LottoClient와 도메인에 퍼져있었던 입출력 로직들을 InputView, OutputView로 옮기기

# Step3

## Todo
- [ ] winningNumber와 bonusNumber 하나의 클래스로 합치기
- [ ] profit과 matchCache를 묶는 상위 클래스 하나 만들기

## Done
- [X] 보너스 당첨 여부에 따른 금액 계산((4개 일치, 당첨) -> 50000, (5개 일치, 당첨) -> 30000000, (5개 일치, 미당첨) -> 1500000, (6개 일치, 당첨) -> 2000000000)
- [X] 보너스 번호 문구 출력(보너스 볼을 입력해 주세요.)
- [X] 보너스 번호 입력
- [X] 당첨 통계 문구 추가("5개 일치, 보너스 볼 일치(30000000원) - 0개")
- [X] winningNumber와 bonusNumber 하나의 클래스로 합치기
- [X] profit과 matchCache를 묶는 상위 클래스 하나 만들기
- [X] LottoPricing에서 Map 키 값 만들어주는 부분 enum으로 분리
- [X] LottoPricing에 lottoPricingMappingCache 부분 반복문이나 stream()으로 처리
- [X] WinningNumber 클래스 이름 변경(WinningNumber => WinningLotto)
- [X] matchCount와 bonusCount를 구하는 부분을 WinningLotto에 메시지를 보내는 형태로 수정

# Step4

## Todo
- [ ] 수동으로 구매하는 번호들은 6개가 아니면 예외(1,2,3,4,5,6,7 => IllegalArgumentException, empty => IllegalArgumentException)
- [ ] 수동으로 구매하는 번호들은 6개가 아니면 예외(1,2,3,4,5,6,7 => IllegalArgumentException, empty => IllegalArgumentException)
- [ ] 출력 => "수동으로 구매할 로또 수를 입력해 주세요."
- [ ] 입력 => 수동으로 구매할 로또 개수 
- [ ] 출력 => "수동으로 구매할 번호를 입력해 주세요."
- [ ] 입력 => 수동으로 구매할 번호
- [ ] 출력 => "수동으로 {수동 구매 개수}장, 자동으로 {자동 구매 개수}개를 구매했습니다."

## Done
- [X] 수동으로 구매할 로또 개수가 null이면 예외(null => IllegalArgumentException)
- [X] 수동으로 구매할 로또 개수가 구매할 수 있는 로또 개수보다 크면 예외(14000, 15 => IllegalArgumentException)
- [X] 수동으로 구매하는 번호들은 중복되면 예외(1,1,3,5,6,7 => IllegalArgumentException)
- [X] 수동으로 구매하는 번호들은 1 ~ 45를 벗어나는 숫자라면 예외(0 -> IllegalArgumentException, 46 -> IllegalArgumentException)

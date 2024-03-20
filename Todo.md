# Step1

## Todo

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
- [ ] LottoClient - 출력("구입금액을 입력해 주세요.")
- [ ] LottoClient - 숫자 입력
- [ ] LottoClient - 구매한 로또 개수 출력("15개를 구매했습니다.")
- [ ] LottoClient - 구매한 로또 개수만큼 6자리 로또 번호 출력("[8, 21, 23, 41, 42, 43]")
- [ ] LottoClient - 출력("지난 주 당첨 번호를 입력해 주세요.")
- [ ] LottoClient - 입력("1, 2, 3, 4, 5, 6")
- [ ] LottoClient - 출력("당첨 통계")
- [ ] LottoClient - 출력("---------")
- [ ] LottoClient - 일치 금액 + 일치 개수 출력("3개 일치 (5000원)- 1개")
- [ ] LottoClient - 총 수익률 출력("총 수익률은 0.35입니다.") 

## Done
- [X] Cash - 1000보다 작으면 예외(1000 => IllegalArgumentException, 0 => IllegalArgumentException)
- [X] Cash - 1000으로 나눈 몫을 반환(14000 => 14, 20123 => 20)
- [X] Match - 2 개의 배열 중에 하나라도 null이면 예외((null,null) => IllegalArgumentException, (null,empty) => IllegalArgumentException)
- [X] Match - 두 개의 배열을 비교하여 일치하는 개수 반환((1,2,3],[1,2,3]) => 3, ([1,0,4],[1,2,3]) => 1, ([1],[1,2,3,4] =>1))
- [X] Profit - 수익금 계산(1 => 0, 3 => 5000, 6 => 2000000000)
- [X] Profit - 누적 수익금 계산(3,3,4,6 => 2000060000)
- [X] Profit - 내가 낸 금액과 수익금을 통해서 수익률 계산((14000, 5000) => 0.35, (2000, 2000000000) => 1000000, (10, 0) => 0)
- [X] LottoGenerator - 1 ~ 45 사이의 중복되지 않고 오름차순으로 정렬된 6개 정수 생성(1,2,3,4,5,6)

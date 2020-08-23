# To-Do List
- Lotto Ticket 구현
    - [x] input 부분에 대해 체크
    - [x] 6개의 숫자 입력부분에 대한 validation
    - [x] contains 구현 체크
    - [x] 일급 컬렉션 안에 List<String> -> List<Integer> 로 변경(Refactoring)
 
- Lotto Number Generator 구현
    - [x] 로또 숫자 범위 1-45 까지의 리스트 구현
    - [x] 6개의 숫자 랜덤 산출
    - [x] 6개의 숫자 정렬
    - [x] step2의 문구처럼 정렬 후 출력
    - [x] Generator 최종 return 형태가 LottoTicket이 되도록 수정

- Lotto 스코어 기록 Enum 이용 구현
    - [x] 1-6등까지의 상수 구현
    - [x] 보너스볼 일치여부 분리하는 내용 필요
    
- Lotto Stat 구현
    - [ ] LottoTicket 입력 메소드로 받기
    - [ ] LottoTicket 결과에 대한 내용을 내부 컬렉션에 저장
    - [ ] 등수에 대한 입력이 들어올 때, 해당되는 인원수 return 구현
    
- InputView 구현
    - [x] 금액부 입력 출력 및 입력
    - [x] 정답값(1등) 당첨번호 입력
    - [x] 보너스볼 입력에 따른 구현 추가
 
- OutputView 구현
    - [x] n개 일치부 출력
    - [x] 수익률 비율 계산(BigDecimal 활용해서 출력)
    - [ ] 보너스볼 일치에 따른 2등 결과값 출력
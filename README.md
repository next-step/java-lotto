# 로또
## Step1. 문자열 덧셈 계산기
#### 기능 구현 목록
* input String split후 delimiters, numbers 추출 기능
* 숫자들의 합 계산 기능
* 숫자 이외의 값 또는 음수 전달 시 RuntimeException 예외 throw

#### 요구사항
* 모든 로직에 단위 테스트를 구현 (UI기능 제외)
* 자바 코드 컨벤션
* else 예약어 쓰지 않기
* README.md 작성 
* commit메시지는 기능 목록 단위로 구분
* method는 한 가지 일만 하도록

#### 링크
* <https://google.github.io/styleguide/javaguide.html> 또는 <https://myeonguni.tistory.com/1596>
* [AngularJS Commit Message Conventions]( AngularJS Commit Message Conventions)
***
## Step1. 로또(자동)
#### 기능 구현 목록
* 구입 금액 입력 받는 기능
* 구입 금액 확인 후 14개의 로또 생성
* 14개의 로또 번호 추출(Collections.shuffle())
* 각 로또 번호 정렬(Collections.sort()) 후 print
* 지난 주 당첨 번호 입력 받는 기능
* 일치하는 개수에 따라 통계 추출
* 총 수익률 계산


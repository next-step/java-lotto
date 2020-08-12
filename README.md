# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능
#### view 
[ ] 문자열 입력 기능
[ ] 결과 출력 기능

#### 입력된 문자열 유효성체크 
[ ] null, 빈값 입력 시, 0을 반환한다.
[ ] 숫자 하나 입력 시, 입력한 숫자를 반환한다. 
[ ] 음수 입력 시, RuntimeException이 발생한다. 
[ ] 숫자 아닌 문자열 입력시 IllegalException 발생한다. 

#### 계산 및 로직 
[ ] 문자열 분리하는 구분자 설정 기능
[ ] 문자열 분리 기능 (기본 분리기, 커스텀 분리기)

[ ] 덧셈 계산 기능

## 실패하는 단위 테스트
[X] 덧셈 기능 (Integer List를 넘기면 담긴 값들의 합이 반환된다.)
[X] 입력값이 숫자인지 확인 기능 (util)
[X] null, 빈값 입력 확인 기능 (util)
[ ] 음수 입력 확인 기능 (util)
[X] 문자열 -> 숫자 변환 기능 (util)

[ ] null, 빈값 입력 시, 0을 반환한다.
[ ] 숫자 하나 입력 시, 입력한 숫자를 반환한다. 
[ ] 음수 입력 시, RuntimeException이 발생한다. 

[ ] 문자열 분리하는 구분자 설정 잘됐는지 확인
[ ] 문자열 분리 기능(기본 분리 ",", ":")
[ ] 문자열 분리 기능(커스텀 분리)
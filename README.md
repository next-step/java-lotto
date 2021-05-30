# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 문자열 덧셈 계산기

### 기능 요구사항
1. 구분자(쉼표,콜론)으로 분리된 숫자의 합 계산
2. 커스텀 구분자 사용가능
   2.1 커스텀 구분자가 있을경우에만 파싱을 다르게 해주는 기능 필요
3. 숫자가 아니거나, 음수일경우 RuntimeException

### 기능 분리
1. split string | null => string[]
2. sum string[] => int

### 유의사항
1. string.split 의경우 regex를 인자로 받는데 meta character의 경우에 literal한 문자로 인식하게 위해서는 Pattern.quote를 사용

## 로또(자동)

### 기능 요구사항
1. [x] 금액에 맞는 로또게임 발행
2. [x] 로또게임 생성
3. [x] 로또번호 생성
4. [x] 랜덤번호 생성
5. [x] 당첨번호와 일치하는 숫자 갯수 세기
6. [x] 수익률 계산
7. [x] 구입금액, 지난주 당첨번호 입력받기
   - 입력 검증
8. [x] 구입금액, 로또게임, 지난주 당첨번호, 당첨통계, 수익률 출력뷰

## 로또(2등)

### 기능 요구사항
1. 2등을 위해 추가 번호를 하나 더 추첨한다.
2. 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항
1. java enum을 적용해 프로그래밍을 구현한다.
2. 규칙 8: 일급 콜렉션을 쓴다.

### 기능목록
1. [ ] 로또 2등 Rank를 구분하기
2. [ ] 통계에 추가하기
3. [x] 로또 번호 생성(전략)
4. [x] 로또 한자리 LottoNumber생성 => factory
5. [x] random의 경우 input 필요 x, cutom의 경우 정해진 input 받아야함

### 노트
1. 로또는 자동 혹은 수동이다. => 변경점 시사
2. 로또를 자동 혹은 수동으로 생성할 수 있다. 
   - 팩토리로 자동, 수동 로또를 만든다. Lottos -> Factory -> RandomLotto or CustomLotto
   - 팩토리로 랜덤 번호, 수동 번호를 generate한다. Lottos -> Lotto -> RandomGenerator or CustomGenerator
3. Lottos는 수동, 자동을 동적으로 결정해서 생성할 수 있다.
4. factory 전략을 바꾸기 위해서 매번 setStrategy를 호출해줘야함 어떻게 중복을 처리할 수 없을까?

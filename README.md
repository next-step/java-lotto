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



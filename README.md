# Baekjoon-Algorithm-Program
백준 알고리즘 문제를 사이트에서 보고 문제를 하나씩 풀어가는게 귀찮아서 만든 프로그램입니다.
문제 번호에 해당하는 백준 사이트에서 예시를 파싱해서, 입력한 코드를 실행 및 결과를 출력합니다.

## 사용법
1. src/main/java/com/algorithm/baekjoon/Main.java 파일을 열고, `PROBLEM_NUMBER` 변수에 풀고자 하는 문제 번호를 입력합니다.
2. 문제번호가 들어간 Class를 만든다.
3. "BaekjoonProblem" 인터페이스를 구현한다.
4. 'solution' 메서드에 문제 풀이 코드를 작성한다. (결과를 String으로 반환)
5. 프로그램을 실행한다.
6. 콘솔창에 결과가 출력됩니다.

## 예시
```java
/// Main.java
package com.algorithm;

import com.algorithm.baekjoon.problem.BaekjoonProblem;
import com.algorithm.baekjoon.problem.P1007;
import com.algorithm.common.Executor;

public class Main {

    private static final Class<? extends BaekjoonProblem> PROBLEM = P1007.class; // 문제 번호에 해당하는 Class로 변경

    public static void main(String[] args) throws Exception {
        Executor.execute(PROBLEM);
    }
}
```
```java
///  P1007.java
package com.algorithm.baekjoon.problem;

public class P1007 implements BaekjoonProblem {
    public String solution(String input) {
        return "abc";
    }
}
```

### 테스트 케이스
'resources/baekjoon/problem' 하위에 테스트 케이스가 자동으로 생성된다. (백준 사이트에서 파싱해온 테스트 케이스)

#### 테스트 케이스 추가
테스트 케이스를 추가하고 싶다면, 'resources/baekjoon/problem/{문제번호}' 폴더에 'INPUT-{문제번호}-n.txt', 'OUTPUT-{문제번호}-n.txt' 파일을 추가하면 됩니다.
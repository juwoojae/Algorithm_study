import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] prime;

    public static void isPrime() {    //에라토스테네스의 채 알고리즘을 사용해서 prime배열 갱신
        for (int i = 2; i < N + 1; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i < N + 1; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < N + 1; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];
        isPrime();
        List<Integer> primeArr = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (prime[i]) {
                primeArr.add(i);
            }
        }
        int tmp = 0;
        int st = 0;
        int ans = 0;
        for (int en = 0; en < primeArr.size(); en++) {  //tmp<=N인 경우 : en포인터를 한칸옮기고, 누적합갱신
            tmp += primeArr.get(en);
            while (tmp > N && st < en) {     //tmp>N인 경우 : st포인터를 한칸옮기고, 누적합 갱신
                tmp -= primeArr.get(st);
                st += 1;
                // System.out.println(tmp);
            }
            if (tmp == N) {    //소수의 누적합과 N 이 같아지는 케이스 :답
                ans += 1;
            }
        }
        System.out.println(ans);

    }
}
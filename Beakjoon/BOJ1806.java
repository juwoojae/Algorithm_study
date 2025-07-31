import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    static final int INF = 2100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int s = 0;
        int tmp = 0; //누적합을 저장 start<=  <end 항까지의 합
        int ans = INF;
        for (int e = 0; e < N; e++) {
            tmp += arr[e];
            while (tmp >= M && s <= e) {
                ans = Math.min(e - s + 1, ans);
                tmp -= arr[s];
                s += 1;
            }
        }
        if (ans == INF) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
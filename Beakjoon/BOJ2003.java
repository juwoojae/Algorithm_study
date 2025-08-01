import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        //입력
        int S = 0;
        int st = 0;
        int ans = 0;
        for (int en = 0; en < N; en++) {
            S += arr[en];
            while (S > M && en > st) {
                S -= arr[st];
                st++;
            }
            //S<=M 라는 것
            if (S == M) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
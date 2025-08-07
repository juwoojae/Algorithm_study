import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] bound = new int[2];  //{start,end}
        int ans = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        //-----입력-------------
        Arrays.sort(arr);   //오름차순 정렬
        if (arr[0] != 1) {
            ans = 1;
        } else {
            bound = new int[]{0, 1};
            for (int i = 1; i < N; i++) {
                if (bound[0] + arr[i] <= bound[1] + 1) {
                    bound[1] += arr[i];
                } else {
                    ans = bound[1] + 1;
                }
            }
            if (ans == -1) {  //모든저울을 다쓰고도 위의 케이스에 걸리지 않는다면
                ans = bound[1] + 1;
            }
        }
        System.out.println(ans);
    }
}

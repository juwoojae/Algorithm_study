import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        //입력
        int en = 0;
        long ans = 0L;
        boolean[] visited = new boolean[100000 + 1];   //st ~ en 까지 연속된 부분수열의 방문표시
        visited[arr[0]] = true;
        for (int st = 0; st < N; st++) {  //en =0 , st =0
            while (en < N - 1 && !visited[arr[en + 1]]) {  //en+1 이 방문된 적이 없다면
                en++;
                visited[arr[en]] = true;  //en 확장 & en+1 방문표시
            }
            //st ~ en 중복이 없는 연속된 부분수열
            ans += (en - st + 1);
            visited[arr[st]] = false;
            if (st == en && en<N-1) {    //만약 st 와 en 이 같다면 길이가 1인수열이므로 en<st 를 방지해 줘야 한다
                    en++;   //en 과 st 를 같이 늘린다
                    visited[arr[en]]=true;
            }
        }
        System.out.println(ans);
    }
}
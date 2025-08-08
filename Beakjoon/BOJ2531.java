import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        //벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[2 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            arr[i + N] = arr[i];
        }
        int[] visited = new int[3000 + 1];
        int cnt = 0;
        int en = 0;
        int st = 0;
        int ans = 0;
        for (; en < k; en++) { //en 은 3이 되어야 함
            if (visited[arr[en]] == 0) {
                cnt++;
            }
            visited[arr[en]]++;
        }
        if (visited[c] == 0) {
            ans=cnt+1;
        }
        ans = cnt;
        while (en < 2 * N - 1) {
            if (visited[arr[st]] - 1 == 0) {   //st 포인터를 올리기 전에 cn초기화
                cnt--;
            }
            visited[arr[st]]--;
            st++;
            // 포인터를 한칸씩 올린후, visited,cnt ,ans 갱신하기
            if (visited[arr[en]] == 0) {
                cnt++;
            }
            visited[arr[en]] += 1;
            if (visited[c] == 0) {
                ans = Math.max(ans, cnt + 1);
            } else {
                ans = Math.max(ans, cnt);
            }
            en++;
        }
        System.out.println(ans);
    }
}
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
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        int[] visited = new int[100000 + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int st = 0;//시작 포인터
        int Len = 1;
        for (int en = 0; en < N; en++) {
            ++visited[arr[en]];//방문표시
            while (visited[arr[en]] > K) { //end을 증가 시켰을때 K 상한을 넘어간다면 st를 움직여서 K보다 같게 만들어 준다
                visited[arr[st++]]--;
            }
            Len = Math.max(Len, en - st + 1);
            //visited[en]<=K일때 for루프로 돌아가서 en증가
        }
        System.out.println(Len);
    }
}
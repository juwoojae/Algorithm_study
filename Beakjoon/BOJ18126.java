import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] edge;
    static long[] distance;   //1부터 떨어진 거리

    public static Long bfs() {
        long ans = 0L;   //가장 먼곳
        distance[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);  //방문 표시
        while (!q.isEmpty()) {   //q 가 빌때 까지
            int x = q.poll();
            for (int i = 1; i < N + 1; i++) {
                if (edge[x][i] > 0 && distance[i] == -1) {   //path 가 존재함과 동시에, 방문된적이 없다면
                    q.offer(i);//방문표시
                    distance[i] = distance[x] + edge[x][i];
                    ans = Math.max(ans, distance[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;
        edge = new int[N + 1][N + 1];   //edge[u][v]=w 이다
        distance = new long[N + 1];//1부터 v까지 떨어진 거리 /-1이면 방문 x
        for (int i = 0; i < N + 1; i++) {
            distance[i] = -1;
        }    //initializing
        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            edge[u][v] = w;
            edge[v][u] = w;
        }
        System.out.println(bfs());
    }
}

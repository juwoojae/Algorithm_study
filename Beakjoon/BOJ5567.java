import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static int n;   //노드 갯수
    static int m;   //간선 갯수
    static int ans; //친구,친구의 친구 수

    static List<List<Integer>> edge = new ArrayList<>();  //간선 정보를 저장하는 2차원 리스트
    static int[] distance;  //1 - distance[v] 까지 가는 최단거리

    static void BFS() {
        distance[1] = 0;//방문표시
        Queue<Integer> q = new LinkedList<>(List.of(1));
        while (!q.isEmpty()) {  // q 가 빌때 까지
            int nowNode = q.poll();
            for (int nextNode : edge.get(nowNode)) {  //현재 노드와 인접한 모든노드에 대해서
                if (distance[nextNode] == -1) { //방문이 안된 노드가 있다면
                    distance[nextNode] = distance[nowNode] + 1;//방문 표시
                    q.offer(nextNode);  //q에 추가하기
                    if(distance[nextNode]==1 || distance[nextNode]==2){
                        ans++; // 친구나 친구의 친구이므로
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n + 1; i++) {
            edge.add(new ArrayList<>()); //2차원 리스트 선언
        }
        for (int i = 0; i < m; i++) {   //간선 2차원 리스트 초기화
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            edge.get(u).add(v);
            edge.get(v).add(u);
        }
        distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {  //distance 초기화
            distance[i] = -1;
        }
        BFS();
        System.out.println(ans);
    }
}

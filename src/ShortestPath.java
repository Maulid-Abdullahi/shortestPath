  public class ShortestPath {

        public int minDistance(int dist[], Boolean b[]) {
            int min = Integer.MAX_VALUE, index = -1;
            for (int x = 0; x < 5; x++) {
                if (b[x] == false && dist[x] <= min) {
                    min = dist[x];
                    index = x;
                }

            }
            return index;
        }

        public void printGraph(int dist[], int x) {
            System.out.println("Distance from source to Destination is :  ");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "----------" + dist[i]);
            }
        }

        public void dijkstra(int graph[][], int src) {
            int dist[] = new int[5];
            Boolean b[] = new Boolean[5];
            for (int i = 0; i < 5; i++) {
                dist[i] = Integer.MAX_VALUE;
                b[i] = false;
            }
            dist[0] = 0;
            for (int count = 0; count < 5; count++) {
                int u = minDistance(dist, b);
                b[u] = true;
                for (int x = 0; x < 5; x++) {
                    if (!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x]) {
                        dist[x] = dist[u] + graph[u][x];
                    }

                }
                printGraph(dist, 5);

            }
        }

        public static void main(String[] args) {
            int graph[][] = new int[][]{
                    {0, 5, 6, 12, 0},
                    {5, 0, 8, 0, 15},
                    {6, 8, 0, 2, 7},
                    {12, 0, 2, 0, 17},
                    {0, 15, 7, 17, 0}
            };
            ShortestPath p = new ShortestPath();
            p.dijkstra(graph, 0);
        }


    }


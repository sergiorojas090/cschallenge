
public class CSChallenge {

   
    public static void main(String[] args) {
         long matrixA[][]={{0,2,99,99,99,99,7,99,99}, 
                           {2,0,99,99,1,1,99,99,2},
                           {99,99,0,99,99,99,99,99,99},
                           {99,99,99,0,99,7,99,99,6},
                           {99,1,99,99,0,99,3,1,99},
                           {99,1,99,7,99,0,99,5,99},
                           {7,99,99,99,3,99,0,1,99},
                           {99,99,99,99,1,99,1,0,99},
                           {99,2,99,6,99,99,99,99,0}};
         BestRoute route = new BestRoute();
         System.out.println(route.FloydAlgorithm(matrixA));
    }
    
}

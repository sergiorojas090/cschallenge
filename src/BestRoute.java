
public class BestRoute {
    //method for determinate all ways using floyd algorithm.
    public String FloydAlgorithm(long [][]mAdy){
        int vertex=mAdy.length;
        long matrixWeight[][]=mAdy;
        String Routes[][]= new String [vertex][vertex];// save the routes for going each vertex
        String AuxRoute[][]= new String[vertex][vertex]; 
        String PathTraveled="", link="", ways="";
        int i,j,k;
        float temp1,temp2,temp3,temp4,min;
        //Strting the matrix routes and aux route;
        for (i = 0; i < vertex; i++) {
            for (j=0;j<vertex;j++) {
                Routes[i][j]="";
                AuxRoute[i][j]="";   
            }  
        }
        for (k = 0; k < vertex; k++) {
            for (i = 0; i < vertex; i++) {
                for (j = 0; j < vertex; j++) {
                    temp1=matrixWeight[i][j]; //adding n ordering and locating the min route
                    temp2=matrixWeight[i][k];
                    temp3=matrixWeight[k][j];
                    temp4=temp2+temp3;
                    //finding the minimun route
                    min=Math.min(temp1, temp4);
                    if (temp1!=temp4) {
                        if (min==temp4) {
                            PathTraveled="";
                            AuxRoute[i][j]=k+"";
                            Routes[i][j]=routesRecursive(i,k,AuxRoute,PathTraveled)+(k+1);
    
                        }
                    }
                    matrixWeight[i][j]=(long) min; //float to long
             }
            }
           }
            //Adding the minium path to string
            for (i=0;i<vertex;i++) {
             for (j=0;j<vertex;j++) {
                link= link+"["+matrixWeight[i][j]+"]"; // creating the minimum matrix 
            }  
            link += "\n";
        }
        ///////////////////////
        for (i=0;i<vertex;i++) {
            for (j=0;j<vertex;j++) {
                if (matrixWeight[i][j]!=100) { //ignoring the infinite 
                    if (i != j) { // if is different than the same index 
                        if (Routes[i][j]. equals("")) {
                            ways +="From room ("+(i+1)+" to "+(j+1)+") take this way...("+(i+1)+", "+(j+1)+"). \n";      
                        }else{
                            ways +="From room ("+(i+1)+" to "+(j+1)+") take this way...("+(i+1)+", "+Routes[i][j]+", "+(j+1)+"). \n";
                        }
                        
                    }
                }
               
            }
        }
        return "The matrix with the shorters ways beetwen offices is:  \n"+link+ "\n The diferent short ways beetween offices are: \n"+ways;
        
        
    }
    public String routesRecursive(int i, int k, String[][]AuxRoute, String PathTraveled){
        if (AuxRoute[i][k].equals("")) {
            return "";
        }else{
            
            PathTraveled += routesRecursive(i,Integer.parseInt(AuxRoute[i][k].toString()),AuxRoute,PathTraveled)+(Integer.parseInt(AuxRoute[i][k].toString())+1)+", ";
            return PathTraveled;
        }
    }
    
}

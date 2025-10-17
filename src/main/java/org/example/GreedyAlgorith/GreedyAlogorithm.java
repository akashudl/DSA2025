package org.example.GreedyAlgorith;

public class GreedyAlogorithm {
    public static void main(String[] args) {



    }

    public static int twoCitySchedCost(int[][] costs) {
        int mincost=0;
        int k=0;
        for(int i=0;i<costs.length;i++){
            int profit=0;
            profit=costs[i][k+1]-costs[i][k];
            if(profit>0){
                mincost+=costs[i][k];
            }else {
                mincost+=costs[i][k+1];
            }
        }
        System.out.println(mincost);
        return mincost;
    }
}

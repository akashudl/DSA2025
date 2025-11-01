package org.example.PrefiXSum;

public class prefixsum2d {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        prefixsum2darryacomputation(arr);
    }
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
      int row=dig.length , col=dig[0].length;

        int[][] grid = new int[n][n];
        for (int[] d : dig) {
            grid[d[0]][d[1]] = 1; // 1 = dug, 0 = not dug
        }
        int ps[][]=new int [n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ps[i + 1][j + 1] = ps[i + 1][j] + ps[i][ j+ 1] - ps[i][j] + grid[i][j];
            }
        }
        int ans=0;
        for(int []a:artifacts){
            int artifact_size = (a[3]-a[1] + 1) * (a[2]-a[0]+1);
            int r1 = a[0] + 1;
            int c1 = a[1] + 1;
            int r2 = a[2] + 1;
            int c2 = a[3] + 1; // psum is 1-index
            int excavation_size = ps[r2][c2] - ps[r1-1][c2] -ps[r2][c1-1] + ps[r1-1][c1-1];
            if(artifact_size==excavation_size){
                ++ans;
            }
        }
        return  ans;
    }
    private static void prefixsum2darryacomputation(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;
        int prefixsum[][]=new int [row][col];
        prefixsum[0][0]=arr[0][0];
        for(int i=1;i<col;i++)
        {
            prefixsum[0][i]=prefixsum[0][i-1]+arr[0][i];
        }

        for(int i=1;i<row;i++)
        {
            prefixsum[i][0]=prefixsum[i-1][0]+arr[i][0];
        }

        for(int i=1;i<row;i++)
        {
          for(int j=1;j<col;j++){
              prefixsum[i][j]=prefixsum[i-1][j]+prefixsum[i][j-1]-prefixsum[i-1][j-1]+arr[i][j];
          }
        }


        // prjinting
        for (int i = 0; i < prefixsum.length; i++) {           // rows
            for (int j = 0; j < prefixsum[i].length; j++) {   // columns
                System.out.print(prefixsum[i][j] + " ");
            }
            System.out.println();
        }
    }


}

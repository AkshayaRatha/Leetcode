class Solution {
    static class selva{
        int i;
        int j;
        int time;
        selva(int i, int j, int time){
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<selva> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new selva(i,j,0));
                }
            }
        }
        int dir[][]={
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
        };
        while(!queue.isEmpty()){
            selva temp=queue.poll();
            for(int k=0;k<4;k++){
                int ii=temp.i+dir[k][0];
                int jj=temp.j+dir[k][1];
                if(ii>=0 && ii<m && jj>=0 && jj<n && grid[ii][jj]==1){
                    grid[ii][jj]=2;
                    queue.add(new selva(ii,jj,temp.time+1));
                    time=Math.max(time,temp.time+1);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}
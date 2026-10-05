class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,text1,text2,dp,m,n);
    }
    int func(int i, int j, String text1, String text2, int[][]dp, int m, int n){
        if(i==m||j==n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+ func(i+1,j+1, text1, text2,dp,m, n);
        }
        
        int c1=func(i+1,j,text1,text2,dp,m,n);
        int c2=func(i,j+1, text1, text2,dp,m,n);
        return dp[i][j]=Math.max(c1,c2);

    }
}

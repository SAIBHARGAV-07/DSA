class Solution {
    public int kthFactor(int n, int k) {
        int c=0,v=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                c++;
                if(c==k){
                    v=i;
                }
            }
        }
        if(c<k){
            return -1;
        }
        else{
            return v;
        }
    }
}
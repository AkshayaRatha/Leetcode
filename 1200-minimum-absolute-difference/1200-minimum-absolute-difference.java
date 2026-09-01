class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;

        for(int i = 0; i < n - 1; i++){
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < minAbsDiff){
                minAbsDiff = diff;
            }
        }

        for(int i = 0; i < n - 1; i++){
            int diff = arr[i+1] - arr[i];
            if(diff == minAbsDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);

                ans.add(new ArrayList<>(list));
            }
        }
        return ans;
    }
}
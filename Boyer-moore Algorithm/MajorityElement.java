class MajorityElement {
    /** 
    Using modified Boyer-moore Algorithm
    For n/k, array can have atmost k-1 majority elements.  So using map instead of two variables to generalize solution.
    There are only 2 possibilities:
    case 1: if new element is already in candidates then increase the count of the candidate.
    case 2: if not then 
        2a: if any candidate has 0 votes then remove that candidate and make curr a new candidate.
        2b: Otherwise reduce the votes of all candidates by 1;
    **/
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length, k=3, minFrequency = (length/k)+1;
        List<Integer> result = new ArrayList<>();
        
        // This map stores candidates and their votes.
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<length;i++){
            int curr = nums[i];
            
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
            } else{
                if(map.size()<=k-1)   map.put(curr,1);
                else{
                    // if any candidate has 0 votes?
                    int candidateKey=-1;
                    for(Integer candidate : map.keySet()){
                        int votes = map.get(candidate);
                        if(votes==0){
                            candidateKey = candidate;
                            break;
                        }
                    }
                    // if there's a candidate with 0 votes then remove that candidate and add curr as a new candidate;
                    if(candidateKey!=-1){
                        map.remove(candidateKey);
                        map.put(curr,1);
                    } else{ //no candidate with 0 votes so reduce votes of all candidates by 1, since the curr is not voting anyone.
                        for(Integer candidate : map.keySet()){
                            int votes = map.get(candidate);
                            map.put(candidate, votes-1);
                        } 
                    }
                }
            }
        } 
        // Now check if any of the candidates have majority votes, if so add to the result.
        for(Integer candidate : map.keySet()){
            int votes = map.get(candidate);
            if(votes>0){
                votes =0;
                for(int i=0;i<length;i++){
                    if(nums[i]==candidate)  votes++;
                }
            }
            if(votes>=minFrequency) result.add(candidate);
        }
        return result;
    }
}
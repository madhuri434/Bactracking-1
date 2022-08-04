// recursion
//tc: exponential
//sc: exponential
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // initialize result to new arraylist
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());


        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path ){

        //base
        if(target < 0 || index == candidates.length) return;

        if(target == 0){
            result.add(path);
            return;
        }

        // logic
        // 0 case or do not choose case

        helper(candidates, target, index + 1, new ArrayList<>(path));
        path.add(candidates[index]);

        // 1 case or choose case
        helper(candidates, target - candidates[index], index,  new ArrayList<>(path));
        //more time and more space because of new ArrayList<>(path)


    }

}

//Backtrack
//do not need to maintain multiple lists, that can save time and space

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // initialize result to new arraylist
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());


        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path ){

        //base
        if(target < 0 || index == candidates.length) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // 0 case or do not choose case

        helper(candidates, target, index + 1, path);
        //actio
        path.add(candidates[index]);

        // 1 case or choose case
        //recursion
        helper(candidates, target - candidates[index], index, path);
        //more time and more space because of new ArrayList<>(path)

        //backtracking
        path.remove(path.size() - 1);

    }

}

// //for loop based backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // initialize result to new arraylist
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());


        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path ){

        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //always index, law
        for(int i = index; i < candidates.length; i++){
            //action
            path.add(candidates[i]); //last element
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);

        }

    }

}


//for loop based recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // initialize result to new arraylist
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());


        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path ){

        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        //always index, law
        for(int i = index; i < candidates.length; i++){
            //action
            List<Integer> newlist = new ArrayList<>(path);
            newlist.add(candidates[i]); //last element
            //recurse
            helper(candidates, target - candidates[i], i, newlist);


        }

    }

}
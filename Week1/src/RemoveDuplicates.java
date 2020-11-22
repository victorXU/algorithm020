/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 快慢指针，i慢，j快，如果遇到nums[i]!=nums[j]
 * 则把nums[j]放在nums[i]下一个位置
 * 最后返回i+1

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        int i=0;
        for (int j=1;j<nums.length;j++){

            if (nums[j]!=nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}

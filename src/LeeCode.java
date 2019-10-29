import java.util.Stack;

public class LeeCode {
    /**
     * 分别当前数字对应的左边最大的和右边最大的数
     * 而后根据列进行雨水存储的计算，存储的雨水是左右两个墙较小的那个减去当前所在墙的高度所得的结果
     * @param height 整形数组
     * @return 存储雨水的最大量
     */
    public int trap2(int[] height) {
        int sum = 0;
        //最左边和最右边无法存储雨水  所以不在计算中
        for(int i =1; i<height.length-1;i++){
            int max_left = 0;
            for(int j = i-1;j>=0;j--){
                if(max_left < height[j]){
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for(int j = i+1;j<height.length;j++){
                if(max_right < height[j]){
                    max_right = height[j];
                }
            }
        int min = Math.min(max_left,max_right);
            if(min>height[i]){
                sum =sum+ (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 根据每一行去计算雨水量
     * @param height 数组
     * @return 存储雨水量
     */
    public int trap1(int[] height) {
        int sum = 0;
        //找到最大高度进行遍历
        int max = getMax(height);
        for(int i = 1;i<=max;i++){
            boolean isstart = false;
            int temp_sum = 0;
            for (int aHeight : height) {
                //isstart 是 是否开始更新temp
                if (isstart && aHeight < i) {
                    temp_sum++;
                }
                if (aHeight >= i) {
                    sum += temp_sum;
                    temp_sum = 0;
                    isstart = true;
                }
            }
        }
        return  sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int aHeight : height) {
            if (aHeight > max) {
                max = aHeight;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeeCode l = new LeeCode();
        int []arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(l.trap2(arr));
    }
}

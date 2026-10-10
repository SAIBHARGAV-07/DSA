import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];
        long operations = (long) k1 + k2;

        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long low = 0, high = maxDiff;

        // Find the maximum difference level after operations
        while (low < high) {
            long mid = low + (high - low) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long level = low;
        long remaining = operations;

        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                remaining -= diff[i] - level;
                diff[i] = level;
            }
        }

        // Use remaining operations to reduce values at the final level
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level && diff[i] > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long answer = 0;

        for (long d : diff) {
            answer += d * d;
        }

        return answer;
    }
}
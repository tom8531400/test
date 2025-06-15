package org.example;

public class LeeCode {
    public static void main(String[] args) {
        LeeCode leeCode = new LeeCode();
//        int[] nums = new int[]{-1, -2, -3, -4, -5};
//        int target = -8;
//        int[] ints = leeCode.twoSum(nums, target);
//        if (ints != null) {
//            for (int i : ints) {
//                System.out.print(i);
//            }
//        }
        // 2,4,3
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode l2 = new ListNode(9, new ListNode(9, null));
        ListNode response = leeCode.addTwoNumbers(l1, l2);
        while (response != null) {
            System.out.print(response.val);
            response = response.next;
        }
    }


//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    if (nums[i] + nums[j] == target) {
//                        if (i > j) {
//                            return new int[]{j, i};
//                        } else {
//                            return new int[]{i, j};
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }


//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            int n = target - nums[i];
//            if(map.containsKey(n)){
//                return new int[]{i , map.get(n)};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode response = null;
        ListNode next = null;
        int num;
        int temp = 0;
        while (true) {
            Integer l1Value = l1 == null ? 0 : l1.val;
            Integer l2Value = l2 == null ? 0 : l2.val;
            if (l1 == null && l2 == null) {
                break;
            }



            if (l1Value + l2Value >= 10) {
                if (temp == 0) {
                    num = l1Value + l2Value - 10;
                    temp = 1;
                } else {
                    if (temp + l1Value + l2Value > 10) {
                        num = l1Value + l2Value + 1 - 10;
                    } else {
                        num = temp + l1Value + l2Value;
                        temp = 0;
                    }
                }
            } else {
                if (temp + l1Value + l2Value >= 10) {
                    num = l1Value + l2Value + temp - 10;
                    temp = 1;
                } else {
                    num = l1Value + l2Value + temp;
                    temp = 0;
                }
            }
            if (l1 != null) {
                l1 = l1.next == null ? null : l1.next;
            }
            if (l2 != null) {
                l2 = l2.next == null ? null : l2.next;
            }
            if (response == null) {
                response = new ListNode(num);
                next = response;
            } else {
                next.next = new ListNode(num);
                next = next.next;
            }
        }
        if (temp != 0) {
            next.next = new ListNode(temp);
        }
        return response;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
